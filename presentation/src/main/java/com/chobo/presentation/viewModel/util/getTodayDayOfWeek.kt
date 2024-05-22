package com.chobo.presentation.viewModel.util

import java.time.LocalDate

fun getTodayDayOfWeek(): String =
    listOf("월", "화", "수", "목", "금", "토", "일")[LocalDate.now().dayOfWeek.value - 1]