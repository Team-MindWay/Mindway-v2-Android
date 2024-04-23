package com.chobo.presentation.viewModel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class HomeAddBookViewModel @Inject constructor() : ViewModel() {
    private val _titleTextState = MutableStateFlow("")
    val titleTextState: StateFlow<String> = _titleTextState.asStateFlow()

    private val _contentTextState = MutableStateFlow("")
    val contentTextState: StateFlow<String> = _contentTextState.asStateFlow()

    private val _titleTextStateIsEmpty = MutableStateFlow(false)
    val titleTextStateIsEmpty: StateFlow<Boolean> = _titleTextStateIsEmpty.asStateFlow()

    private val _contentTextStateIsEmpty = MutableStateFlow(false)
    val contentTextStateIsEmpty: StateFlow<Boolean> = _contentTextStateIsEmpty.asStateFlow()

    val contentTextMaxLength
        get() = 1000
    fun updateTitleTextState(input:String){
        _titleTextStateIsEmpty.value = false
        _titleTextState.value = input
    }
    fun updateContentTextState(input:String){
        _contentTextStateIsEmpty.value = false
        _contentTextState.value = input
    }
    fun checkButton() {
        _titleTextStateIsEmpty.value = _titleTextState.value.isEmpty()
        _contentTextStateIsEmpty.value = _contentTextState.value.isEmpty()
    }
}
