package com.chobo.data.remote.dto.event.response

import com.chobo.domain.model.event.response.GetEventListResponseModel

data class GetEventListResponse(
    val id: Long,
    val title: String,
    val content: String,
    val img_url: String,
    val created_at: String,
    val ended_at: String?
)

fun GetEventListResponse.toModel() = GetEventListResponseModel(
    id = id,
    title = title,
    content = content,
    img_url = img_url,
    created_at = created_at,
    ended_at = ended_at
)