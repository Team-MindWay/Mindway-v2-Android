package com.chobo.presentation.viewModel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class BookAddBookViewModel @Inject constructor() : ViewModel() {
    private val _titleTextState = MutableStateFlow("")
    val titleTextState: StateFlow<String>
        get() = _titleTextState

    private val _writeTextState = MutableStateFlow("")
    val writeTextState: StateFlow<String>
        get() = _writeTextState

    private val _linkTextState = MutableStateFlow("")
    val linkTextState: StateFlow<String>
        get() = _linkTextState

    fun checkButton() {

    }
}