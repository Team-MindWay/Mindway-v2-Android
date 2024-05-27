package com.chobo.data.remote.dto.recommend.request

import com.chobo.domain.model.recommend.request.RecommendRequestAllModel

data class RecommendAllRequest(
    val title: String,
    val content: String,
    val author: String
)

fun RecommendRequestAllModel.toDto() = RecommendAllRequest(
    title = title,
    content = content,
    author = author
)