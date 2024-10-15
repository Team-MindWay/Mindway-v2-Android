package com.chobo.presentation.viewModel.event

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chobo.domain.emumtype.EventRequestListStatusType
import com.chobo.domain.emumtype.EventRequestListStatusType.*
import com.chobo.domain.usecase.event.GetEventListUseCase
import com.chobo.presentation.viewModel.event.uistate.GetEventListUiState
import com.chobo.presentation.viewModel.util.Result
import com.chobo.presentation.viewModel.util.asResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EventViewModel @Inject constructor(
    private val getEventListUseCase: GetEventListUseCase
) : ViewModel() {
    private val _swipeRefreshLoading = MutableStateFlow(false)
    val swipeRefreshLoading = _swipeRefreshLoading.asStateFlow()

    private val _getNowEventListUiState =
        MutableStateFlow<GetEventListUiState>(GetEventListUiState.Loading)
    val getNowEventListUiState = _getNowEventListUiState.asStateFlow()

    private val _getEventListUiState =
        MutableStateFlow<GetEventListUiState>(GetEventListUiState.Loading)
    val getPastEventListUiState = _getEventListUiState.asStateFlow()

    fun getEventList(type: EventRequestListStatusType) = viewModelScope.launch {
        _swipeRefreshLoading.value = true
        val targetData = when (type) {
            NOW -> _getNowEventListUiState
            PAST -> _getEventListUiState
        }
        getEventListUseCase(status = type.name)
            .asResult()
            .collectLatest { result ->
                when (result) {
                    is Result.Loading -> targetData.value = GetEventListUiState.Loading
                    is Result.Success -> if (result.data.isEmpty()) {
                        targetData.value = GetEventListUiState.Empty
                        _swipeRefreshLoading.value = false
                    } else {
                        targetData.value =
                            GetEventListUiState.Success(result.data.toImmutableList())
                        _swipeRefreshLoading.value = false
                    }

                    is Result.Fail -> {
                        targetData.value = GetEventListUiState.Fail
                        _swipeRefreshLoading.value = false
                    }
                }
            }
    }
}