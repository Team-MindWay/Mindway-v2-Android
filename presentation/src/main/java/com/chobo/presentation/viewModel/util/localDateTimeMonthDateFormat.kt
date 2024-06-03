package com.chobo.presentation.viewModel.util

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

fun localDateTimeMonthDateFormat(localDateTime: LocalDateTime): String =
    localDateTime.format(DateTimeFormatter.ofPattern("M월 d일"))