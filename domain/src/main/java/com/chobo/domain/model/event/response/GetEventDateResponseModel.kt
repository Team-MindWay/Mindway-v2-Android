package com.chobo.domain.model.event.response

import java.io.File

data class GetEventDateResponseModel(
    val title: String,
    val content: String,
    val image: File,
    val startedAt: String,
    val endedAt: String
)