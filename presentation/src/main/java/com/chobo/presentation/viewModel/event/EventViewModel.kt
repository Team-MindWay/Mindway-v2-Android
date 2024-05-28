package com.chobo.presentation.viewModel.event

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chobo.domain.usecase.event.GetEventListUseCase
import com.chobo.presentation.viewModel.event.uistate.GetEventListUiState
import com.chobo.presentation.viewModel.util.result.Result
import com.chobo.presentation.viewModel.util.result.asResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
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

    private val _getEventListUiState = MutableStateFlow<GetEventListUiState>(GetEventListUiState.Loading)
    val getEventListUiState = _getEventListUiState.asStateFlow()

    init {
        loadStuff()
    }

    fun loadStuff() {
        viewModelScope.launch {
            _swipeRefreshLoading.value = true
            delay(1000L)
            _swipeRefreshLoading.value = false
        }
    }

    fun getEventPastList(status: String) = viewModelScope.launch {
        getEventListUseCase(status = status)
            .asResult()
            .collectLatest { result ->
                when (result) {
                    is Result.Loading -> _getEventListUiState.value = GetEventListUiState.Loading
                    is Result.Success -> if (result.data.isEmpty()) {
                        _getEventListUiState.value = GetEventListUiState.Empty
                    } else {
                        _getEventListUiState.value = GetEventListUiState.Success(result.data)
                    }
                    is Result.Fail -> _getEventListUiState.value = GetEventListUiState.Fail(result.exception)
                }
            }
    }

    fun getEventList(status: String) = viewModelScope.launch {
        getEventListUseCase(status = status)
            .asResult()
            .collectLatest { result ->
                when(result) {
                    is Result.Loading -> _getEventListUiState.value = GetEventListUiState.Loading
                    is Result.Success -> if (result.data.isEmpty()) {
                        _getEventListUiState.value = GetEventListUiState.Empty
                    } else {
                        _getEventListUiState.value = GetEventListUiState.Success(result.data)
                    }
                    is Result.Fail -> _getEventListUiState.value = GetEventListUiState.Fail(result.exception)
                }
            }
    }

    fun onCurrentEventClick(index: Int) {
    }

    fun onPastEventClick(index: Int) {
    }
}