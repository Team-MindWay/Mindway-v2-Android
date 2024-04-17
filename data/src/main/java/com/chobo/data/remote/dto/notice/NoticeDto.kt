package com.chobo.data.remote.dto.notice

import com.google.gson.annotations.SerializedName

data class NoticeDto(
    @SerializedName("title")
    val title: String,
    @SerializedName("content")
    val content: String
)
