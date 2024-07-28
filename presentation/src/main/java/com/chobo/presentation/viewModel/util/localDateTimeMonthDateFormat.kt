package com.chobo.presentation.viewModel.util

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

fun LocalDateTime.localDateTimeMonthDateFormat(): String =
    this.format(DateTimeFormatter.ofPattern("MM월 dd일"))