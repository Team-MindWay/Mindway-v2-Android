package com.chobo.data.remote.dto.order_request

import com.chobo.domain.model.order.OrderRequestBodyModel
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class OrderRequestBody(
    @Json(name = "title") val title: String,
    @Json(name = "author") val author: String,
    @Json(name = "book_url") val book_url: String,
)

fun OrderRequestBody.toModel() = OrderRequestBodyModel(
    title = title,
    author = author,
    book_url = book_url
)

fun OrderRequestBodyModel.toDto() = OrderRequestBody(
    title = title,
    author = author,
    book_url = book_url
)