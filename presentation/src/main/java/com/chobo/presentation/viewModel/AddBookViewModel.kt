package com.chobo.presentation.viewModel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class AddBookViewModel @Inject constructor() : ViewModel() {
    private val _titleTextState = MutableStateFlow("")
    val titleTextState: StateFlow<String>
        get() = _titleTextState
    val titleTextMaxLength
        get() = 60

    private val _contentTextState = MutableStateFlow("")
    val contentTextState: StateFlow<String>
        get() = _contentTextState
    val contentTextMaxLength
        get() = 300
    fun checkButton() {

    }
}
