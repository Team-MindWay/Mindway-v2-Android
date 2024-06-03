package com.chobo.domain.model.order

data class OrderRequestBodyModel(
    val title: String,
    val author: String,
    val book_url: String,
)