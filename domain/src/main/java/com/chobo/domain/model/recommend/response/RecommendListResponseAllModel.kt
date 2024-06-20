package com.chobo.domain.model.recommend.response

import androidx.compose.runtime.Immutable

@Immutable
data class RecommendListResponseAllModel(
    val title: String,
    val content: String,
    val author: String
)