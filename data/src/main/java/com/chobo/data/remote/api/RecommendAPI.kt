package com.chobo.data.remote.api

import com.chobo.data.remote.dto.recommend.request.RecommendAllRequest
import com.chobo.data.remote.dto.recommend.response.GetRecommendBookListResponse
import retrofit2.http.*

interface RecommendAPI {

    @POST("/api/v2/recommend")
    suspend fun postRecommendBook(
        @Body body: RecommendAllRequest,
        @Query("type") type: String
    )

    @GET("/api/v2/recommend")
    suspend fun getRecommendBookList(
        @Query("type") type: String
    ): List<GetRecommendBookListResponse>

    @PATCH("/api/v2/recommend/{rec_id}")
    suspend fun patchRecommendBook(
        @Body body: RecommendAllRequest,
        @Path("rec_id") id: Long
    )

    @DELETE("/api/v2/recommend/{rec_id}")
    suspend fun deleteRecommendBook(
        @Path("rec_id") id: Long
    )
}