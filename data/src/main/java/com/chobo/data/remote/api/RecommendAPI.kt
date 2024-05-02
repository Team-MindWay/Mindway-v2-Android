package com.chobo.data.remote.api

import com.chobo.data.remote.dto.recommend.RecommendAll
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.Path

interface RecommendAPI {

    @POST("/api/v2/recommend")
    suspend fun postRecommendBook(
        @Body body: RecommendAll
    )

    @GET("/api/v2/recommend")
    suspend fun getRecommendBook(): RecommendAll

    @PATCH("/api/v2/recommend/{rec_id}")
    suspend fun patchRecommendBook(
        @Body body: RecommendAll,
        @Path("rec_id") id: Long
    )

    @DELETE("/api/v2/recommend/{rec_id}")
    suspend fun deleteRecommendBook(
        @Path("rec_id") id: Long
    )
}