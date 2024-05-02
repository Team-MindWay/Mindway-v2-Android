package com.chobo.domain.model.recommend.response

data class RecommendListResponseAllModel(
    val title: List<String>,
    val content: List<String>,
    val author: List<String>
)