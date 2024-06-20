package com.chobo.domain.model.notice

import androidx.compose.runtime.Immutable

@Immutable
data class NoticeAllModel(
    val title: String = "",
    val content: String = ""
)
