package com.chobo.data.remote.dto.recommend.response

import com.chobo.domain.model.recommend.response.RecommendListResponseAllModel
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GetRecommendBookListResponse(
    @Json(name = "title") val title: String,
    @Json(name = "content") val content: String,
    @Json(name = "author") val author: String
)

fun GetRecommendBookListResponse.toModel() = RecommendListResponseAllModel(
    title = title,
    content = content,
    author = author
)