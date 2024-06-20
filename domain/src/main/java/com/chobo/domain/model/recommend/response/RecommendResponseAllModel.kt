package com.chobo.domain.model.recommend.response

import androidx.compose.runtime.Immutable

@Immutable
data class RecommendResponseAllModel(
    val title: String,
    val content: String,
    val author: String
)