package com.chobo.data.remote.dto.event.response

import com.chobo.domain.model.event.response.GetDetailEventResponseModel

data class GetDetailEventResponse(
    val title: String,
    val content: String,
    val image: String,
    val startedAt: String,
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