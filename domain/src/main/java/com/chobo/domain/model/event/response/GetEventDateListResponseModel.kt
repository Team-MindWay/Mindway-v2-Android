package com.chobo.domain.model.event.response

import okhttp3.MultipartReader

data class GetEventDateListResponseModel(
    val title: String,
    val content: String,
    val image: MultipartReader,
    val startedAt: String,
    val endedAt: String
)
