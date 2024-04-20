package com.chobo.data.remote.dto.event.response

import com.google.gson.annotations.SerializedName

data class EventListResponse(
    @SerializedName("title")
    val title: String,
    @SerializedName("content")
    val content: String
)