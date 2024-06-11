package com.chobo.presentation.viewModel.util

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale

fun formatServerDate(dateString: String): String {
    val serverDateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
    val desiredDateFormatter = DateTimeFormatter.ofPattern("yyyy년 M월 d일", Locale.getDefault())
    val date = LocalDate.parse(dateString, serverDateFormatter)
    return date.format(desiredDateFormatter)
}