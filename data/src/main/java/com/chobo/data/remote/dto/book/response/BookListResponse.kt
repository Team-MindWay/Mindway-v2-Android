package com.chobo.data.remote.dto.book.response

import com.chobo.domain.model.book.response.BookListResponseModel
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class BookListResponse(
    @Json(name = "id") val id: Long,
    @Json(name = "title") val title: String,
    @Json(name = "plot") val plot: String,
    @Json(name = "date") val date: String,
)

fun BookListResponse.toModel() = BookListResponseModel(
    id = id,
    title = title,
    plot = plot,
    date = date
)
