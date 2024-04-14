package com.chobo.presentation.viewModel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class MyBookEditViewModel @Inject constructor():ViewModel() {
    private val _titleTextState = MutableStateFlow("임시 데이터입니당")
    val titleTextState: StateFlow<String> = _titleTextState.asStateFlow()

    private val _writeTextState = MutableStateFlow("임시 데이터입니당임시 데이터입니당임시 데이터입니당")
    val writeTextState: StateFlow<String> = _writeTextState.asStateFlow()

    private val _linkTextState = MutableStateFlow("임시 데이터입니당임시 데이터입니당임시 데이터입니당")
    val linkTextState: StateFlow<String> = _linkTextState.asStateFlow()

    fun checkButton() {

    }
}