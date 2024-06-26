package com.chobo.data.remote.dto.book.request

import com.chobo.domain.model.book.request.BookRequestBodyModel

data class BookRequestBody(
    val title: String,
    val plot: String
)

fun BookRequestBodyModel.toDto() = BookRequestBody(
    title = title,
    plot = plot
)

fun BookRequestBody.toModel() = BookRequestBodyModel(
    title = title,
    plot = plot
)
