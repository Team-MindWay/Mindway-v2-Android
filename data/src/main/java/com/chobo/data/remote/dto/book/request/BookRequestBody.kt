package com.chobo.data.remote.dto.book.request

import com.google.gson.annotations.SerializedName

data class BookRequestBody(
    @SerializedName("title")
    val title: String,
    @SerializedName("plot")
    val plot: String
)