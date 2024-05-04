package com.chobo.data.remote.api

import com.chobo.data.remote.dto.notice.NoticeAll
import retrofit2.http.GET

interface NoticeAPI {
    @GET("/api/v2/notice")
    suspend fun noticeGet(): NoticeAll
}