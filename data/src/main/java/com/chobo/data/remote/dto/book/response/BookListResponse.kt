package com.chobo.data.remote.dto.book.response

import com.chobo.domain.model.book.response.BookListResponseModel
import com.google.gson.annotations.SerializedName

data class BookListResponse(
    @SerializedName("title")
    val title: String,
    @SerializedName("plot")
    val plot: String,
    @SerializedName("created_at")
    val created_at: String
)

fun BookListResponse.toModel(): BookListResponseModel = BookListResponseModel(
    title = this.title,
    plot = this.plot,
    created_at = this.created_at
)
