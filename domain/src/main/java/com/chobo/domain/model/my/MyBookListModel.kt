package com.chobo.domain.model.my

import androidx.compose.runtime.Immutable

@Immutable
data class MyBookListModel(
    val id: Long,
    val title: String,
    val author: String,
    val bookUrl: String
)
