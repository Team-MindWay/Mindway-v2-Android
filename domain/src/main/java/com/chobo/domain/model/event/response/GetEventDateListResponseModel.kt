package com.chobo.domain.model.event.response

data class GetEventDateListResponseModel(
    val title: String,
    val content: String,
    val image: String,
    val startedAt: String,
    val endedAt: String
)
