package com.chobo.domain.model.book.response

data class BookListResponseModel(
    val id: Long,
    val title: String,
    val plot: String,
    val created_at: String,
)