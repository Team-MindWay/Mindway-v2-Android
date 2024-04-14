package com.chobo.presentation.viewModel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class MyBookEditViewModel @Inject constructor():ViewModel() {
    private val _titleTextState = MutableStateFlow("")
    val titleTextState: StateFlow<String> = _titleTextState.asStateFlow()

    private val _writeTextState = MutableStateFlow("")
    val writeTextState: StateFlow<String> = _writeTextState.asStateFlow()

    private val _linkTextState = MutableStateFlow("")
    val linkTextState: StateFlow<String> = _linkTextState.asStateFlow()

    fun updateTitleTextState(input:String){
        _titleTextState.value = input
    }
    fun updateWriteTextState(input:String){
        _writeTextState.value = input
    }
    fun updateLinkTextState(input:String){
        _linkTextState.value = input
    }

    fun checkButton() {

    }
    init {
        _titleTextState.value = "임시 데이터입니당"
        _writeTextState.value = "임시 데이터입니당임시 데이터입니당임시 데이터입니당"
        _linkTextState.value = "임시 데이터입니당임시 데이터입니당임시 데이터입니당"
    }
}