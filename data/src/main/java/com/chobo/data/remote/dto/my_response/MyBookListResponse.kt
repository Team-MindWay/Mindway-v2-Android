package com.chobo.data.remote.dto.my_response

import com.chobo.domain.model.my.MyBookListModel
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MyBookListResponse(
    @Json(name = "id") val id: Long,
    @Json(name = "title") val title: String,
    @Json(name = "author") val author: String,
    @Json(name = "book_url") val bookUrl: String
)

fun MyBookListResponse.toModel() = MyBookListModel(
    id = id,
    title = title,
    author = author,
    bookUrl = bookUrl
)

fun MyBookListModel.toDto() = MyBookListResponse(
    id = id,
    title = title,
    author = author,
    bookUrl = bookUrl
)

