package com.chobo.data.remote.api

import com.chobo.data.remote.dto.request.goal.GoalGetResponseBody
import com.chobo.data.remote.dto.response.goal.GoalResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface GoalAPI {
    @POST("/api/v2/goal")
    fun goalPost(
        @Header("Authorization") authorization: String,
    )

    @GET("/api/v2/goal")
    fun goalGet(
        @Header("refreshToken") refreshToken: String,
        @Body body: GoalGetResponseBody,
    ): Call<GoalResponse>
}