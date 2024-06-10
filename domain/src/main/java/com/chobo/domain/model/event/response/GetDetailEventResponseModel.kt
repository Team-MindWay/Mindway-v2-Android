package com.chobo.domain.model.event.response

data class GetDetailEventResponseModel(
    val title: String,
    val content: String,
    val img_url: String,
    val started_at: String?,
    val ended_at: String?
)
