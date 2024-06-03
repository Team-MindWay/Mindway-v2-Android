package com.chobo.data.remote.dto.book.response

import com.chobo.domain.model.book.response.BookListResponseModel

data class BookListResponse(
    val title: String,
    val plot: String,
    val created_at: String
)

fun BookListResponse.toModel() = BookListResponseModel(
    title = title,
    plot = plot,
    created_at = created_at
)
