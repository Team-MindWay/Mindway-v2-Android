package com.chobo.data.remote.dto.event.response

import com.chobo.domain.model.event.response.GetDetailEventResponseModel
import java.io.File

data class GetDetailEventResponse(
    val title: String,
    val content: String,
    val image: File,
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