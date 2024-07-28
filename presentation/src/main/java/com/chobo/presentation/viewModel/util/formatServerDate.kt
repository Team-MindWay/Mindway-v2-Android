package com.chobo.presentation.viewModel.util

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale

fun String.formatServerDate(): String =
    LocalDate.parse(this, DateTimeFormatter.ofPattern("yyyy-MM-dd"))
        .format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일",Locale.getDefault()))