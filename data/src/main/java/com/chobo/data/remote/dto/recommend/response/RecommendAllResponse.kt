package com.chobo.data.remote.dto.recommend.response

import com.chobo.domain.model.recommend.response.RecommendResponseAllModel
import com.google.gson.annotations.SerializedName

data class RecommendAllResponse(
    @SerializedName("title")
    val title: String,
    @SerializedName("content")
    val content: String,
    @SerializedName("author")
    val author: String
)

fun RecommendAllResponse.toAllRecommendResponseModel(): RecommendResponseAllModel {
    return RecommendResponseAllModel(
        title = title,
        content = content,
        author = author
    )
}