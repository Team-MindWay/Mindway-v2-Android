package com.chobo.presentation.viewModel.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chobo.domain.model.book.request.BookRequestBodyModel
import com.chobo.domain.usecase.book.BookUploadUseCase
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
) : ViewModel() {
    private val _titleTextState = MutableStateFlow("")
    val titleTextState: StateFlow<String> = _titleTextState.asStateFlow()

    private val _contentTextState = MutableStateFlow("")
    val contentTextState: StateFlow<String> = _contentTextState.asStateFlow()

    private val _titleTextStateIsEmpty = MutableStateFlow(false)
    val titleTextStateIsEmpty: StateFlow<Boolean> = _titleTextStateIsEmpty.asStateFlow()

    private val _contentTextStateIsEmpty = MutableStateFlow(false)
    val contentTextStateIsEmpty: StateFlow<Boolean> = _contentTextStateIsEmpty.asStateFlow()

    fun updateTitleTextState(input: String) {
        _titleTextStateIsEmpty.value = false
        _titleTextState.value = input
    }

    fun updateContentTextState(input: String) {
        _contentTextStateIsEmpty.value = false
        _contentTextState.value = input
    }

    fun checkButtonOnClick() {
        _titleTextStateIsEmpty.value = _titleTextState.value.isEmpty()
        _contentTextStateIsEmpty.value = _contentTextState.value.isEmpty()
        if (
            !_titleTextStateIsEmpty.value
            && !_contentTextStateIsEmpty.value
        )
            viewModelScope.launch {
                bookUploadUseCase(
                    body = BookRequestBodyModel(
                        title = _titleTextState.value,
                        plot = _contentTextState.value
                    )
                )
                    .asResult()
                    .collectLatest { }
            }
    }
}
