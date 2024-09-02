package com.chobo.presentation.viewModel.main

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chobo.domain.model.book.request.BookRequestBodyModel
import com.chobo.domain.usecase.book.BookUploadUseCase
import com.chobo.presentation.viewModel.util.Result
import com.chobo.presentation.viewModel.util.asResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeAddBookViewModel @Inject constructor(
    private val bookUploadUseCase: BookUploadUseCase,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    companion object {
        const val TITLE = "title"
        const val CONTENT = "content"
    }

    internal var titleTextState = savedStateHandle.getStateFlow(key = TITLE, initialValue = "")

    internal var contentTextState = savedStateHandle.getStateFlow(key = CONTENT, initialValue = "")

    private val _titleTextStateIsEmpty = MutableStateFlow(false)
    val titleTextStateIsEmpty: StateFlow<Boolean> = _titleTextStateIsEmpty.asStateFlow()

    private val _contentTextStateIsEmpty = MutableStateFlow(false)
    val contentTextStateIsEmpty: StateFlow<Boolean> = _contentTextStateIsEmpty.asStateFlow()
    internal fun clearState() {
        onTitleChanged("")
        onContentChanged("")
        _titleTextStateIsEmpty.value = false
        _contentTextStateIsEmpty.value = false
    }

    internal fun validateFields(): Boolean {
        val titleEmpty = titleTextState.value.isEmpty()
        val contentEmpty = contentTextState.value.isEmpty()

        _titleTextStateIsEmpty.value = titleEmpty
        _contentTextStateIsEmpty.value = contentEmpty

        return !titleEmpty && !contentEmpty
    }


    internal fun submitBook() {
            viewModelScope.launch {
                bookUploadUseCase(
                    body = BookRequestBodyModel(
                        title = titleTextState.value,
                        plot = contentTextState.value
                    )
                )
                    .asResult()
                    .collectLatest { }
            }
    }

    internal fun onTitleChanged(title: String) {
        savedStateHandle[TITLE] = title
        _titleTextStateIsEmpty.value = title.isEmpty()
    }

    internal fun onContentChanged(content: String) {
        savedStateHandle[CONTENT] = content
        _contentTextStateIsEmpty.value = content.isEmpty()
    }

    internal fun resetTextState() {
        onTitleChanged("")
        onContentChanged("")
    }
}