package com.chobo.presentation.viewModel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class BookAddBookViewModel @Inject constructor() : ViewModel() {
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

    fun updateTitleTextState(input:String){
        _titleTextStateIsEmpty.value = false
        _titleTextState.value = input
    }
    fun updateWriteTextState(input:String){
        _writeTextStateIsEmpty.value = false
        _writeTextState.value = input
    }
    fun updateLinkTextState(input:String){
        _linkTextStateIsEmpty.value = false
        _linkTextState.value = input
    }
    fun checkButtonOnClick() {
        _titleTextStateIsEmpty.value = _titleTextState.value.isEmpty()
        _writeTextStateIsEmpty.value = _writeTextState.value.isEmpty()
        _linkTextStateIsEmpty.value = _linkTextState.value.isEmpty()
    }
}