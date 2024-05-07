package com.chobo.data.remote.dto.event.request

import com.google.gson.annotations.SerializedName

data class WriteEventRequest(
    @SerializedName("dto")
    val dto: Dto
) {
    data class Dto(
        @SerializedName("title")
        val title: String,
        @SerializedName("content")
        val content: String,
        @SerializedName("started_at")
        val started_at: String,
        @SerializedName("ended_at")
        val ended_at: String
    )
}
