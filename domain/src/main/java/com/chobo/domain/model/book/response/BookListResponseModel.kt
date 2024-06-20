package com.chobo.domain.model.book.response

import androidx.compose.runtime.Immutable

@Immutable
data class BookListResponseModel(
    val id: Long,
    val title: String,
    val plot: String,
    val date: String,
)