package com.chobo.presentation.viewModel.event

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chobo.domain.usecase.event.GetEventListUseCase
import com.chobo.presentation.viewModel.event.uistate.GetNowEventListUiState
import com.chobo.presentation.viewModel.event.uistate.GetPastEventListUiState
import com.chobo.presentation.viewModel.util.Result
import com.chobo.presentation.viewModel.util.asResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EventViewModel @Inject constructor(
    private val getEventListUseCase: GetEventListUseCase
) : ViewModel() {
    private val _getNowEventListUiState = MutableStateFlow<GetNowEventListUiState>(GetNowEventListUiState.Loading)
    val getNowEventListUiState = _getNowEventListUiState.asStateFlow()

    private val _getPastEventListUiState = MutableStateFlow<GetPastEventListUiState>(GetPastEventListUiState.Loading)
    val getPastEventListUiState = _getPastEventListUiState.asStateFlow()

    fun getEventPastList(status: String) = viewModelScope.launch {
        getEventListUseCase(status = status)
            .asResult()
            .collectLatest { result ->
                when (result) {
                    is Result.Loading -> _getPastEventListUiState.value = GetPastEventListUiState.Loading
                    is Result.Success -> if (result.data.isEmpty()) {
                        _getPastEventListUiState.value = GetPastEventListUiState.Empty
                    } else {
                        _getPastEventListUiState.value = GetPastEventListUiState.Success(result.data)
                    }
                    is Result.Fail -> _getPastEventListUiState.value = GetPastEventListUiState.Fail(result.exception)
                }
            }
    }

    fun getEventNowList(status: String) = viewModelScope.launch {
        getEventListUseCase(status = status)
            .asResult()
            .collectLatest { result ->
                when (result) {
                    is Result.Loading -> _getNowEventListUiState.value = GetNowEventListUiState.Loading
                    is Result.Success -> if (result.data.isEmpty()) {
                        _getNowEventListUiState.value = GetNowEventListUiState.Empty
                    } else {
                        _getNowEventListUiState.value = GetNowEventListUiState.Success(result.data)
                    }
                    is Result.Fail -> _getNowEventListUiState.value = GetNowEventListUiState.Fail(result.exception)
                }
            }
    }
}