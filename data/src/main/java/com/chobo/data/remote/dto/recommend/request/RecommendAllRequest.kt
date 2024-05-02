package com.chobo.data.remote.dto.recommend.request

import com.google.gson.annotations.SerializedName
import kotlin.coroutines.RestrictsSuspension

data class RecommendAllRequest(
    @SerializedName("title")
    val title: String,
    @SerializedName("content")
    val content: String,
    @SerializedName("author")
    val author: String
)
