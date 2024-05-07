package com.chobo.domain.model.event.response

data class GetEventListResponseModel(
    val id: Long,
    val title: String,
    val content: String,
    val img_url: String,
    val created_at: String,
    val ended_at: String?
)
