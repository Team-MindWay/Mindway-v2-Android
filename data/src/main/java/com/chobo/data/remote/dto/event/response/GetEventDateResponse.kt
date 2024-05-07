package com.chobo.data.remote.dto.event.response

import com.chobo.domain.model.event.response.GetEventDateResponseModel
import java.io.File

data class GetEventDateResponse(
    val title: String,
    val content: String,
    val image: File,
    val startedAt: String,
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