package com.chobo.presentation.viewModel.util

fun Int.ifZeroThenOne() = if (this == 0) 1 else this