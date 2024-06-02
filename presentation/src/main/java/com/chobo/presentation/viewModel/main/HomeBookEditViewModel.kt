package com.chobo.presentation.viewModel.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chobo.domain.model.book.request.BookRequestBodyModel
import com.chobo.domain.usecase.book.BookModifyUseCase
import com.chobo.presentation.viewModel.util.errorHandling
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeBookEditViewModel @Inject constructor(
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

    val plotTextMaxLength: Int
        get() = 1000

    fun updateTitleTextState(input: String) {
        _titleTextStateIsEmpty.value = false
        _titleTextState.value = input
    }

    fun updatePlotTextState(input: String) {
        _plotTextStateIsEmpty.value = false
        _plotTextState.value = input
    }

    fun checkButtonOnClick(id: Long) {
        _titleTextStateIsEmpty.value = _titleTextState.value.isEmpty()
        _plotTextStateIsEmpty.value = _plotTextState.value.isEmpty()
        if (
            _titleTextStateIsEmpty.value
            && _plotTextStateIsEmpty.value
        ) {
            viewModelScope.launch {
                bookModifyUseCase(
                    bookRequestBodyModel = BookRequestBodyModel(
                        title = titleTextState.value,
                        plot = _plotTextState.value,
                    ),
                    bookId = id
                )
                    .onSuccess {
                        it.catch { remoteError ->
                            remoteError.errorHandling<Unit>()
                        }
                    }
                    .onFailure {
                        it.errorHandling<Unit>()
                    }
            }
        }
    }
}