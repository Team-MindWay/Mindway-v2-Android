package com.chobo.presentation.viewModel.event

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chobo.domain.usecase.event.GetDetailEventUseCase
import com.chobo.domain.usecase.event.GetEventDateListUseCase
import com.chobo.domain.usecase.event.GetEventListUseCase
import com.chobo.presentation.viewModel.event.uistate.GetDetailEventUiState
import com.chobo.presentation.viewModel.event.uistate.GetEventDateListUiState
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
    private val getEventListUseCase: GetEventListUseCase,
    private val getEventDetailUseCase: GetDetailEventUseCase,
    private val getEventDateListUseCase: GetEventDateListUseCase,
) : ViewModel() {
    private val _isLoading = MutableStateFlow(false)
    val isLoading = _isLoading.asStateFlow()

    private val _getEventListUiState = MutableStateFlow<GetEventListUiState>(GetEventListUiState.Loading)
    val getEventListUiState = _getEventListUiState.asStateFlow()

    private val _getDetailEventUiState = MutableStateFlow<GetDetailEventUiState>(GetDetailEventUiState.Loading)
    val getDetailEventUiState = _getDetailEventUiState.asStateFlow()

    private val _getEventDateListUiState = MutableStateFlow<GetEventDateListUiState>(GetEventDateListUiState.Loading)
    val getEventDateListUiState = _getEventDateListUiState.asStateFlow()

    init {
        loadStuff()
    }

    fun loadStuff() {
        viewModelScope.launch {
            _isLoading.value = true
            delay(1500L)
            _isLoading.value = false
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

    fun getDetailEvent(eventId: Long) = viewModelScope.launch {
        getEventDetailUseCase(eventId = eventId)
            .asResult()
            .collectLatest { result ->
                when(result) {
                    is Result.Loading -> _getDetailEventUiState.value = GetDetailEventUiState.Loading
                    is Result.Success -> _getDetailEventUiState.value = GetDetailEventUiState.Success(result.data)
                    is Result.Fail -> _getDetailEventUiState.value = GetDetailEventUiState.Fail(result.exception)
                }
            }
    }

    fun getEventDataList(date: String) = viewModelScope.launch {
        getEventDateListUseCase(date = date)
            .asResult()
            .collectLatest { result ->
                when(result) {
                    is Result.Loading -> _getEventDateListUiState.value = GetEventDateListUiState.Loading
                    is Result.Success -> {
                        if (result.data.isEmpty()) {
                            _getEventDateListUiState.value = GetEventDateListUiState.Empty
                        } else {
                            _getEventDateListUiState.value =
                                GetEventDateListUiState.Success(result.data)
                        }
                    }
                    is Result.Fail -> _getEventDateListUiState.value = GetEventDateListUiState.Fail(result.exception)
                }
            }
    }

    fun onCurrentEventClick(index: Int) {
    }

    fun onPastEventClick(index: Int) {
    }
}