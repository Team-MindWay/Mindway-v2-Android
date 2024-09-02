package com.chobo.data.remote.dto.notice

import com.chobo.domain.model.notice.NoticeAllModel
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NoticeAll(
    @Json(name = "title") val title: String,
    @Json(name = "content") val content: String
)

fun NoticeAll.toModel() = NoticeAllModel(
    title = title,
    content = content,
)