package com.chobo.data.remote.dto.order_request

import com.chobo.domain.model.order.OrderRequestBodyModel

data class OrderRequestBody(
    val title: String,
    val author: String,
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