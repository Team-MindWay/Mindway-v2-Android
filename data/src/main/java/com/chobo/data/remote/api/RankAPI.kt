package com.chobo.data.remote.api

import com.chobo.data.remote.dto.rank_response.RankResponse
import retrofit2.http.GET

interface RankAPI {
    @GET("/api/v2/rank")
    suspend fun rankGet(): RankResponse
}