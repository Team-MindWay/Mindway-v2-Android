package com.chobo.data.remote.dto.event.response

import com.chobo.domain.model.event.response.GetEventListResponseModel
import com.google.gson.annotations.SerializedName

data class GetEventListResponse(
    @SerializedName("id")
    val id: Long,
    @SerializedName("title")
    val title: String,
    @SerializedName("content")
    val content: String,
    @SerializedName("img_url")
    val img_url: String,
    @SerializedName("created_at")
    val created_at: String,
    @SerializedName("ended_at")
    val ended_at: String?
)

fun GetEventListResponse.toGetEventListResponseModel(): GetEventListResponseModel {
    return GetEventListResponseModel(
        id = id,
        title = title,
        content = content,
        img_url = img_url,
        created_at = created_at,
        ended_at = ended_at
    )
}