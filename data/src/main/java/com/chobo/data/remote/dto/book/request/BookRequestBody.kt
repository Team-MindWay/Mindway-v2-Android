package com.chobo.data.remote.dto.book.request

import com.chobo.domain.model.book.request.BookRequestBodyModel
import com.google.gson.annotations.SerializedName

data class BookRequestBody(
    @SerializedName("title")
    val title: String,
    @SerializedName("plot")
    val plot: String
)

fun BookRequestBodyModel.toDto(): BookRequestBody = BookRequestBody(
    title = this.title,
    plot = this.plot
)

