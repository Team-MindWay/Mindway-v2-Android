package com.chobo.data.remote.dto.event.request

data class EventWriteRequest(
    val title: String,
    val content: String,
    val started_at: String,
    val ended_at: String
)
