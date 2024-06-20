package com.chobo.domain.model.recommend.request

import androidx.compose.runtime.Immutable

@Immutable
data class RecommendRequestAllModel(
    val title: String,
    val content: String,
    val author: String
)
