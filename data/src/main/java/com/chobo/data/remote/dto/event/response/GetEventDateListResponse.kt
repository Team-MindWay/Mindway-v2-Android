package com.chobo.data.remote.dto.event.response

import com.chobo.domain.model.event.response.GetEventDateListResponseModel
import java.io.File

data class GetEventDateListResponse(
    val title: String,
    val content: String,
    val image: File,
    val startedAt: String,
    val endedAt: String
)

fun GetEventDateListResponse.toGetEventDateListResponseModel(): GetEventDateListResponseModel {
    return GetEventDateListResponseModel(
        title = title,
        content = content,
        image = image,
        startedAt = startedAt,
        endedAt = endedAt
    )
}