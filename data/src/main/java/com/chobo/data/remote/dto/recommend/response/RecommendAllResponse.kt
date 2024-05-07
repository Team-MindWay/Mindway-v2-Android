package com.chobo.data.remote.dto.recommend.response

import com.chobo.domain.model.recommend.response.RecommendResponseAllModel

data class RecommendAllResponse(
    val title: String,
    val content: String,
    val author: String
)

fun RecommendAllResponse.toAllRecommendResponseModel(): RecommendResponseAllModel {
    return RecommendResponseAllModel(
        title = title,
        content = content,
        author = author
    )
}