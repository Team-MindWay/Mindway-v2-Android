package com.chobo.presentation.viewModel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class ViewDetailViewModel @Inject constructor() : ViewModel() {
    private val _titleTextState = MutableStateFlow("")
    val titleTextState: StateFlow<String> = _titleTextState.asStateFlow()

    private val _contentTextState = MutableStateFlow("")
    val contentTextState: StateFlow<String> = _contentTextState.asStateFlow()

    fun checkOnclick() {

    }

    init {
        _titleTextState.value = "임시데이터 임시데이터 임시데이터"
        _contentTextState.value = "임시데이터 임시데이터 임시데이터 임시데이터 임시데이터 임시데이터 임시데이터 임시데이터 임시데이터"
    }
}