package com.chobo.presentation.viewModel.util

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale

fun formatServerDate(dateString: String): String =
    LocalDate.parse(dateString, DateTimeFormatter.ofPattern("yyyy-MM-dd"))
        .format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일",Locale.getDefault()))