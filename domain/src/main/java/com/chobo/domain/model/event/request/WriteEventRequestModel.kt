package com.chobo.domain.model.event.request

data class WriteEventRequestModel(
    val dto: Dto
) {
    data class Dto(
        val title: String,
        val content: String,
        val started_at: String,
        val ended_at: String
    )
}

