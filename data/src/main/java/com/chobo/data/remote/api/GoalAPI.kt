package com.chobo.data.remote.api

import com.chobo.data.remote.dto.goal.request.GoalRequestBodyPost
import com.chobo.data.remote.dto.goal.response.GoalResponse
import retrofit2.http.*

interface GoalAPI {
    @POST("/api/v2/order")
    suspend fun orderPost(
        @Body body: GoalRequestBodyPost
    )

    @GET("/api/v2/order")
    suspend fun orderGet(): GoalResponse
}