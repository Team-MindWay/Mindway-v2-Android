package com.chobo.data.remote.api

import com.chobo.data.remote.dto.recommend.request.RecommendAllRequest
import com.chobo.data.remote.dto.recommend.response.RecommendAllResponse
import com.chobo.data.remote.enumtype.OrderRequestBookType
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface RecommendAPI {

    @POST("/api/v2/recommend")
    suspend fun postRecommendBook(
        @Body body: RecommendAllRequest,
        @Query("type") type: OrderRequestBookType
    )

    @GET("/api/v2/recommend")
    suspend fun getRecommendBook(
        @Query("type") type: OrderRequestBookType
    ): RecommendAllResponse

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