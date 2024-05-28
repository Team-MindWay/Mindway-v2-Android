package com.chobo.presentation.viewModel.event

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chobo.domain.usecase.event.GetDetailEventUseCase
import com.chobo.presentation.viewModel.event.uistate.GetDetailEventUiState
import com.chobo.presentation.viewModel.util.result.Result
import com.chobo.presentation.viewModel.util.result.asResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailEventViewModel @Inject constructor(
    private val getEventDetailUseCase: GetDetailEventUseCase,
    ) : ViewModel() {
    private val _getDetailEventUiState = MutableStateFlow<GetDetailEventUiState>(GetDetailEventUiState.Loading)
    val getDetailEventUiState = _getDetailEventUiState.asStateFlow()

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
}
