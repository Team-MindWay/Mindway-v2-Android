package com.chobo.data.remote.dto.book.request

import com.chobo.domain.model.book.request.BookRequestBodyModel
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class BookRequestBody(
    @Json(name = "title") val title: String,
    @Json(name = "plot") val plot: String
)

fun BookRequestBodyModel.toDto() = BookRequestBody(
    title = title,
    plot = plot
)

fun BookRequestBody.toModel() = BookRequestBodyModel(
    title = title,
    plot = plot
)
