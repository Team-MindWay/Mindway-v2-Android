package com.chobo.data.remote.dto.event.request

import com.chobo.domain.model.event.request.WriteEventRequestModel
import com.chobo.domain.model.event.request.WriteEventRequestModel.Dto as DomainDto
import com.google.gson.annotations.SerializedName

data class WriteEventRequest(
    @SerializedName("dto")
    val dto: Dto
) {
    data class Dto(
        @SerializedName("title")
        val title: String,
        @SerializedName("content")
        val content: String,
        @SerializedName("started_at")
        val started_at: String,
        @SerializedName("ended_at")
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
