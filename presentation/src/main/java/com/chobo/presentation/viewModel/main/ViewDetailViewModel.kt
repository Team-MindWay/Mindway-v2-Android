package com.chobo.presentation.viewModel.main

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class ViewDetailViewModel @Inject constructor(
    private val getBookByIdUseCase: GetBookByIdUseCase,
) : ViewModel() {
    private val _getBookByIdUiState =
        MutableStateFlow<GetBookByIdUiState>(GetBookByIdUiState.Loading)
    val getBookByIdUiState: StateFlow<GetBookByIdUiState> = _getBookByIdUiState.asStateFlow()

    private val _checkBookDialogIsVisible = MutableStateFlow(false)
    val checkBookDialogIsVisible: StateFlow<Boolean> = _checkBookDialogIsVisible.asStateFlow()

    fun checkOnclick() {

    }

    fun toggleCheckBookDialogIsVisible() {
        _checkBookDialogIsVisible.value = !_checkBookDialogIsVisible.value
    }

    init {
        _titleTextState.value = "임시데이터 임시데이터 임시데이터"
        _contentTextState.value = "임시데이터 임시데이터 임시데이터 임시데이터 임시데이터 임시데이터 임시데이터 임시데이터 임시데이터"
    }
}