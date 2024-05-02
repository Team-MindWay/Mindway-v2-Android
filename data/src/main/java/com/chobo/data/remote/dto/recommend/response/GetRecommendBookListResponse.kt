package com.chobo.data.remote.dto.recommend.response

import com.chobo.domain.model.recommend.response.RecommendListResponseAllModel
import com.google.gson.annotations.SerializedName

data class GetRecommendBookListResponse(
    @SerializedName("title")
    val title: String,
    @SerializedName("content")
    val content: String,
    @SerializedName("author")
    val author: String
)

fun GetRecommendBookListResponse.toGetRecommendListResponseModel(): RecommendListResponseAllModel {
    return RecommendListResponseAllModel(
        title = title,
        content = content,
        author = author
    )
}