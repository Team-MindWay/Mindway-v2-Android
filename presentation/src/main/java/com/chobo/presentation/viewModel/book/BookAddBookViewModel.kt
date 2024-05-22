package com.chobo.presentation.viewModel.book

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chobo.domain.model.order.OrderRequestBodyModel
import com.chobo.domain.usecase.order.OrderUploadUseCase
import com.chobo.presentation.viewModel.book.uistate.OrderUploadUiState
import com.chobo.presentation.viewModel.util.Event
import com.chobo.presentation.viewModel.util.errorHandling
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BookAddBookViewModel @Inject constructor(
    private val orderUploadUseCase: OrderUploadUseCase
) : ViewModel() {
    private val _titleTextState = MutableStateFlow("")
    val titleTextState: StateFlow<String> = _titleTextState.asStateFlow()

    private val _writeTextState = MutableStateFlow("")
    val writeTextState: StateFlow<String> = _writeTextState.asStateFlow()

    private val _linkTextState = MutableStateFlow("")
    val linkTextState: StateFlow<String> = _linkTextState.asStateFlow()

    private val _titleTextStateIsEmpty = MutableStateFlow(false)
    val titleTextStateIsEmpty: StateFlow<Boolean> = _titleTextStateIsEmpty.asStateFlow()

    private val _writeTextStateIsEmpty = MutableStateFlow(false)
    val writeTextStateIsEmpty: StateFlow<Boolean> = _writeTextStateIsEmpty.asStateFlow()

    private val _linkTextStateIsEmpty = MutableStateFlow(false)
    val linkTextStateIsEmpty: StateFlow<Boolean> = _linkTextStateIsEmpty.asStateFlow()

    private val _checkBookDialog = MutableStateFlow(false)
    val checkBookDialog: StateFlow<Boolean> = _checkBookDialog.asStateFlow()

    private val _orderUploadUiState = MutableStateFlow<OrderUploadUiState>(OrderUploadUiState.Loading)
    val orderUploadUiState: StateFlow<OrderUploadUiState> = _orderUploadUiState.asStateFlow()

    fun updateTitleTextState(input: String) {
        _titleTextStateIsEmpty.value = false
        _titleTextState.value = input
    }

    fun updateWriteTextState(input: String) {
        _writeTextStateIsEmpty.value = false
        _writeTextState.value = input
    }

    fun updateLinkTextState(input: String) {
        _linkTextStateIsEmpty.value = false
        _linkTextState.value = input
    }

    fun toggleCheckBookDialog() {
        _checkBookDialog.value = !_checkBookDialog.value
    }

    fun checkButtonOnClick() {
        _titleTextStateIsEmpty.value = _titleTextState.value.isEmpty()
        _writeTextStateIsEmpty.value = _writeTextState.value.isEmpty()
        _linkTextStateIsEmpty.value = _linkTextState.value.isEmpty()
        if (
            _titleTextState.value.isNotEmpty()
            && _writeTextState.value.isNotEmpty()
            && _linkTextState.value.isNotEmpty()
        ) {
            viewModelScope.launch {
                orderUploadUseCase(
                    body = OrderRequestBodyModel(
                        title = titleTextState.value,
                        author = _writeTextState.value,
                        book_url = linkTextState.value
                    )
                )
                    .onSuccess {
                        it.catch { remoteError ->
                            _orderUploadUiState.value = OrderUploadUiState.RemoteFail(exception = remoteError)
                            remoteError.errorHandling<Unit>()
                        }.collect { response ->
                            _orderUploadUiState.value = OrderUploadUiState.Success
                            Event.Success(data = response)
                        }
                    }
                    .onFailure {
                        _orderUploadUiState.value = OrderUploadUiState.RemoteFail(exception = it)
                        it.errorHandling<Unit>()
                    }
            }
        }
    }
}