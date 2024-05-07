package com.chobo.data.remote.dto.event.request

import com.chobo.domain.model.event.request.WriteEventRequestModel

data class WriteEventRequest(
    val dto: Dto
) {
    data class Dto(
        val title: String,
        val content: String,
        val started_at: String,
        val ended_at: String
    )
}

fun WriteEventRequestModel.toWriteEventRequest(): WriteEventRequest {
    return WriteEventRequest(
        dto = WriteEventRequest.Dto(
            title = this.dto.title,
            content = this.dto.content,
            started_at = this.dto.started_at,
            ended_at = this.dto.ended_at
        )
    )
}
