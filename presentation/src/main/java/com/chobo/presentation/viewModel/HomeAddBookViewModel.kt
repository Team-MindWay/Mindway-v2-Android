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
    val contentTextMaxLength
        get() = 1000
    fun updateTitleTextState(input:String){
        _titleTextState.value = input
    }
    fun updateContentTextState(input:String){
        _contentTextState.value = input
    }
    fun checkButton() {

    }
}
