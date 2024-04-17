package com.chobo.data.remote.api

import com.chobo.data.remote.dto.notice.NoticeDto
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface NoticeAPI {
    @POST("/api/v2/notice")
    suspend fun noticePost(
        @Body body: NoticeDto
    )

    @GET("/api/v2/notice")
    suspend fun noticePost(): NoticeDto
}