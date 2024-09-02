package com.chobo.data.remote.dto.recommend.request

import com.chobo.domain.model.recommend.request.RecommendRequestAllModel
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RecommendAllRequest(
    @Json(name = "title") val title: String,
    @Json(name = "content") val content: String,
    @Json(name = "author") val author: String
)

fun RecommendRequestAllModel.toDto() = RecommendAllRequest(
    title = title,
    content = content,
    author = author
)