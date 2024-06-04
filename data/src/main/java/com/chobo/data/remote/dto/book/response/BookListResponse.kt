package com.chobo.data.remote.dto.book.response

import com.chobo.domain.model.book.response.BookListResponseModel

data class BookListResponse(
    val id: Long,
    val title: String,
    val plot: String,
    val created_at: String,
)

fun BookListResponse.toModel() = BookListResponseModel(
    id = id,
    title = title,
    plot = plot,
    date = created_at
)
