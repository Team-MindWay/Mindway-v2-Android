package com.chobo.data.remote.dto.event.response

import com.chobo.domain.model.event.response.GetDetailEventResponseModel

data class GetDetailEventResponse(
    val title: String,
    val content: String,
    val img_url: String,
    val started_at: String,
    val ended_at: String
)

fun GetDetailEventResponse.toModel() = GetDetailEventResponseModel(
    title = title,
    content = content,
    img_url = img_url,
    started_at = started_at,
    ended_at = ended_at
)