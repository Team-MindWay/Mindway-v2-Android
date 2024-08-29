package com.chobo.presentation.viewModel.book

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chobo.domain.model.order.OrderRequestBodyModel
import com.chobo.domain.usecase.order.OrderUploadUseCase
import com.chobo.presentation.viewModel.book.uistate.OrderUploadUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BookAddBookViewModel @Inject constructor(
    private val orderUploadUseCase: OrderUploadUseCase,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    companion object {
        const val TITLE = "title"
        const val WRITE = "write"
        const val LINK = "link"
    }

    internal var titleTextState = savedStateHandle.getStateFlow(key = TITLE, initialValue = "")

    internal var writeTextState = savedStateHandle.getStateFlow(key = WRITE, initialValue = "")

    internal var linkTextState = savedStateHandle.getStateFlow(key = LINK, initialValue = "")

    private val _titleTextStateIsEmpty = MutableStateFlow(false)
    val titleTextStateIsEmpty: StateFlow<Boolean> = _titleTextStateIsEmpty.asStateFlow()

    private val _writeTextStateIsEmpty = MutableStateFlow(false)
    val writeTextStateIsEmpty: StateFlow<Boolean> = _writeTextStateIsEmpty.asStateFlow()

    private val _linkTextStateIsEmpty = MutableStateFlow(false)
    val linkTextStateIsEmpty: StateFlow<Boolean> = _linkTextStateIsEmpty.asStateFlow()

    private val _orderUploadUiState = MutableStateFlow<OrderUploadUiState>(OrderUploadUiState.Loading)
    val orderUploadUiState: StateFlow<OrderUploadUiState> = _orderUploadUiState.asStateFlow()

    internal fun checkButtonOnClick(
        titleTextState: String,
        writeTextState: String,
        linkTextState: String,
    ) = viewModelScope.launch {
        orderUploadUseCase(
            body = OrderRequestBodyModel(
                title = titleTextState,
                author = writeTextState,
                book_url = linkTextState
            )
        )
            .onSuccess {
                it.catch {
                    _orderUploadUiState.value = OrderUploadUiState.Fail
                }.collect {
                    savedStateHandle[TITLE] = ""
                    savedStateHandle[WRITE] = ""
                    savedStateHandle[LINK] = ""

                    _orderUploadUiState.value = OrderUploadUiState.Success
                }
            }
            .onFailure {
                _orderUploadUiState.value = OrderUploadUiState.Fail
            }
    }

    internal fun onTitleChanged(title: String) {
        savedStateHandle[TITLE] = title
        _titleTextStateIsEmpty.value = title.isEmpty()
    }

    internal fun onWriteChanged(write: String) {
        savedStateHandle[WRITE] = write
        _writeTextStateIsEmpty.value = write.isEmpty()
    }

    internal fun onLinkChanged(link: String) {
        savedStateHandle[LINK] = link
        _linkTextStateIsEmpty.value = link.isEmpty()
    }

    internal fun validateAndSetErrorStates(): Boolean {
        val isTitleEmpty = titleTextState.value.isEmpty()
        val isWriteEmpty = writeTextState.value.isEmpty()
        val isLinkEmpty = linkTextState.value.isEmpty()

        _titleTextStateIsEmpty.value = isTitleEmpty
        _writeTextStateIsEmpty.value = isWriteEmpty
        _linkTextStateIsEmpty.value = isLinkEmpty

        return !isTitleEmpty && !isWriteEmpty && !isLinkEmpty
    }
}