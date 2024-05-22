package com.chobo.data.remote.api

import com.chobo.data.remote.dto.goal.request.GoalRequestBodyPost
import com.chobo.data.remote.dto.goal.response.GoalWeekendResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface GoalAPI {
    @POST("/api/v2/goal")
    suspend fun postGoal(
        @Body body: GoalRequestBodyPost
    )

    @GET("/api/v2/goal")
    suspend fun getWeekendGoal(): GoalWeekendResponse
}