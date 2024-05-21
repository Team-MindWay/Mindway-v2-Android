package com.chobo.data.remote.api

import com.chobo.data.remote.dto.rank.RankResponse
import retrofit2.http.GET

interface RankApi {
    @GET("/api/v2/rank")
    suspend fun rankGet(): List<RankResponse>
}