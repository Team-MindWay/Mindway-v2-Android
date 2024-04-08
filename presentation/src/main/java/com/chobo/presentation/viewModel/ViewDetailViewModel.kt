package com.chobo.presentation.viewModel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ViewDetailViewModel @Inject constructor() : ViewModel() {
    lateinit var title: String
    lateinit var content: String
    init {
        title = "dqwdftuygibhnoimxtrcyvgbhj"
        content = "dwqvbhjknlzrxdtcfvgbjh"
    }
}