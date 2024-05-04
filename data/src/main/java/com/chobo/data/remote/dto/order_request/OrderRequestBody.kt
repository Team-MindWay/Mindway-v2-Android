package com.chobo.data.remote.dto.order_request

import com.chobo.domain.model.order.OrderRequestBodyModel
import com.google.gson.annotations.SerializedName

data class OrderRequestBody(
    @SerializedName("title")
    val title: String,
    @SerializedName("author")
    val author: String,
    @SerializedName("book_url")
    val book_url: String,
)
fun OrderRequestBody.toModel():OrderRequestBodyModel = OrderRequestBodyModel(
    title = title,
    author = author,
    book_url = book_url
)
fun OrderRequestBodyModel.toDto():OrderRequestBody = OrderRequestBody(
    title = title,
    author = author,
    book_url = book_url
)