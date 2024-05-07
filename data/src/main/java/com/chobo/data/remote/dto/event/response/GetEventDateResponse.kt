package com.chobo.data.remote.dto.event.response

import com.chobo.domain.model.event.response.GetEventDateResponseModel
import com.google.gson.annotations.SerializedName
import java.io.File

data class GetEventDateResponse(
    @SerializedName("title")
    val title: String,
    @SerializedName("content")
    val content: String,
    @SerializedName("image")
    val image: File,
    @SerializedName("startAt")
    val startedAt: String,
    @SerializedName("endAt")
    val endedAt: String
)

fun GetEventDateResponse.toGetEventDateResponseModel(): GetEventDateResponseModel {
    return GetEventDateResponseModel(
        title = title,
        content = content,
        image = image,
        startedAt = startedAt,
        endedAt = endedAt
    )
}