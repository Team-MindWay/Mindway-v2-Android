package com.chobo.data.remote.dto.book.response

import com.chobo.domain.model.book.response.BookListResponseModel
import java.time.LocalDateTime

data class BookListResponse(
    val id: Long,
    val title: String,
    val plot: String,
    val created_at: LocalDateTime,
)

fun BookListResponse.toModel() = BookListResponseModel(
    id = id,
    title = title,
    plot = plot,
    created_at = created_at
)
