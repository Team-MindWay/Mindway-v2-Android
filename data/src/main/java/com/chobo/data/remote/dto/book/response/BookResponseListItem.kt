package com.chobo.data.remote.dto.book.response

import com.google.gson.annotations.SerializedName

data class BookResponseListItem(
    @SerializedName("title")
    val title: String,
    @SerializedName("plot")
    val plot: String,
    @SerializedName("created_at")
    val created_at:String
)