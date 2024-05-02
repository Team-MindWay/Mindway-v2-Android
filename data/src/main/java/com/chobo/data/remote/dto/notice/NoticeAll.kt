package com.chobo.data.remote.dto.notice

import com.chobo.domain.model.notice.NoticeAllModel
import com.google.gson.annotations.SerializedName

data class NoticeAll(
    @SerializedName("title")
    val title: String,
    @SerializedName("content")
    val content: String
)

fun NoticeAll.toModel(): NoticeAllModel = NoticeAllModel(
    title = title,
    content = content,
)