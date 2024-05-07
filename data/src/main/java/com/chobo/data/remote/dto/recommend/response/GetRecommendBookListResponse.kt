package com.chobo.data.remote.dto.recommend.response

import com.chobo.domain.model.recommend.response.RecommendListResponseAllModel

data class GetRecommendBookListResponse(
    val title: String,
    val content: String,
    val author: String
)

fun GetRecommendBookListResponse.toGetRecommendListResponseModel(): RecommendListResponseAllModel {
    return RecommendListResponseAllModel(
        title = title,
        content = content,
        author = author
    )
}