package com.chobo.data.remote.dto.event.response

import com.chobo.domain.model.event.response.GetEventListResponseModel
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GetEventListResponse(
    @Json(name = "id") val id: Long,
    @Json(name = "title") val title: String,
    @Json(name = "content") val content: String,
    @Json(name = "img_url") val img_url: String,
    @Json(name = "started_at") val started_at: String,
    @Json(name = "ended_at") val ended_at: String
)

fun GetEventListResponse.toModel() = GetEventListResponseModel(
    id = id,
    title = title,
    content = content,
    img_url = img_url,
    started_at = started_at,
    ended_at = ended_at
)