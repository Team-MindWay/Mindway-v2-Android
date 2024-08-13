package com.chobo.presentation.viewModel.main

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
) : ViewModel() {
    private val _titleTextState = MutableStateFlow("")
    val titleTextState: StateFlow<String> = _titleTextState.asStateFlow()

    private val _plotTextState = MutableStateFlow("")
    val plotTextState: StateFlow<String> = _plotTextState.asStateFlow()

    private val _titleTextStateIsEmpty = MutableStateFlow(false)
    val titleTextStateIsEmpty: StateFlow<Boolean> = _titleTextStateIsEmpty.asStateFlow()

    private val _plotTextStateIsEmpty = MutableStateFlow(false)
    val plotTextStateIsEmpty: StateFlow<Boolean> = _plotTextStateIsEmpty.asStateFlow()

    fun updateTitleTextState(input: String) {
        _titleTextStateIsEmpty.value = false
        _titleTextState.value = input
    }

    fun updatePlotTextState(input: String) {
        _plotTextStateIsEmpty.value = false
        _plotTextState.value = input
    }

    fun getBookById(id: Long) = viewModelScope.launch {
        getBookByIdUseCase(bookId = id)
            .asResult()
            .collectLatest { result ->
                when (result) {
                    is Result.Loading -> Unit
                    is Result.Success -> {
                        _titleTextState.value = result.data.title
                        _plotTextState.value = result.data.plot
                    }

                    is Result.Fail -> {}
                }
            }
    }

    fun checkButtonOnClick(id: Long) {
        _titleTextStateIsEmpty.value = _titleTextState.value.isEmpty()
        _plotTextStateIsEmpty.value = _plotTextState.value.isEmpty()
        if (
            !_titleTextStateIsEmpty.value
            && !_plotTextStateIsEmpty.value
        ) {
            viewModelScope.launch {
                bookModifyUseCase(
                    bookRequestBodyModel = BookRequestBodyModel(
                        title = _titleTextState.value,
                        plot = _plotTextState.value,
                    ),
                    bookId = id
                )
                    .asResult()
                    .collectLatest { }
            }
        }
    }
}