package com.chobo.presentation.viewModel.main

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chobo.domain.model.book.request.BookRequestBodyModel
import com.chobo.domain.usecase.book.BookModifyUseCase
import com.chobo.domain.usecase.book.GetBookByIdUseCase
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
class HomeBookEditViewModel @Inject constructor(
    private val getBookByIdUseCase: GetBookByIdUseCase,
    private val bookModifyUseCase: BookModifyUseCase,
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

    internal fun validateFields(): Boolean {
        val titleEmpty = titleTextState.value.isEmpty()
        val contentEmpty = contentTextState.value.isEmpty()

        _titleTextStateIsEmpty.value = titleEmpty
        _contentTextStateIsEmpty.value = contentEmpty

        return !titleEmpty && !contentEmpty
    }

    internal fun getBookById(id: Long) = viewModelScope.launch {
        getBookByIdUseCase(bookId = id)
            .asResult()
            .collectLatest { result ->
                when (result) {
                    is Result.Loading -> Unit
                    is Result.Success -> {
                        onTitleChange(result.data.title)
                        onContentChange(result.data.plot)
                    }

                    is Result.Fail -> {}
                }
            }
    }

    internal fun checkButtonOnClick(id: Long) {
        viewModelScope.launch {
            bookModifyUseCase(
                bookRequestBodyModel = BookRequestBodyModel(
                    title = titleTextState.value,
                    plot = contentTextState.value,
                ),
                bookId = id
            )
                .asResult()
                .collectLatest { result ->
                    when (result) {
                        is Result.Success -> {
                            savedStateHandle[TITLE] = ""
                            savedStateHandle[CONTENT] = ""
                        }
                        else -> {}
                    }
                }
        }
    }

    internal fun onTitleChange(title: String) {
        savedStateHandle[TITLE] = title
        _titleTextStateIsEmpty.value = title.isEmpty()
    }

    internal fun onContentChange(content: String) {
        savedStateHandle[CONTENT] = content
        _contentTextStateIsEmpty.value = content.isEmpty()
    }
}