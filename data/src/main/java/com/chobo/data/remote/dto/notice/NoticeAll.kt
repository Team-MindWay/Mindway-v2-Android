package com.chobo.data.remote.dto.notice

import com.chobo.domain.model.notice.NoticeAllModel

data class NoticeAll(
    val title: String,
    val content: String
)

fun NoticeAll.toModel(): NoticeAllModel = NoticeAllModel(
    title = title,
    content = content,
)