package com.chobo.data.remote.dto.event.response

import com.chobo.domain.model.event.response.GetDetailEventResponseModel
import com.google.gson.annotations.SerializedName
import java.io.File

data class GetDetailEventResponse(
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

fun GetDetailEventResponse.toGetDetailEventResponseModel(): GetDetailEventResponseModel {
    return GetDetailEventResponseModel(
        title = title,
        content = content,
        image = image,
        startedAt = startedAt,
        endedAt = endedAt
    )
}