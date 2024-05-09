package com.chobo.data.remote.dto.event.response

import com.chobo.domain.model.event.response.GetEventDateListResponseModel
import okhttp3.MultipartReader

data class GetEventDateListResponse(
    val title: String,
    val content: String,
    val image: MultipartReader,
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