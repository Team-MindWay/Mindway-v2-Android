package com.chobo.data.remote.dto.order_request

import com.google.gson.annotations.SerializedName

data class OrderRequestBody(
    @SerializedName("title")
    val title: String,
    @SerializedName("author")
    val author: String,
    @SerializedName("book_url")
    val book_url: String,
)