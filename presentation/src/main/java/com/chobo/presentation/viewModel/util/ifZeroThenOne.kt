package com.chobo.presentation.viewModel.util

fun Int.ifZeroThenOne(): Int {
    return if (this == 0) 1 else this
}
