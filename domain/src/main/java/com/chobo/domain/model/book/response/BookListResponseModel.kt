package com.chobo.domain.model.book.response

import java.time.LocalDateTime

data class BookListResponseModel(
    val id: Long,
    val title: String,
    val plot: String,
    val created_at: LocalDateTime,
)