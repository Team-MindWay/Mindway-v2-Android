package com.chobo.data.remote.dto.notice

import com.google.gson.annotations.SerializedName

data class NoticeAll(
    @SerializedName("title")
    val title: String,
    @SerializedName("content")
    val content: String
)
