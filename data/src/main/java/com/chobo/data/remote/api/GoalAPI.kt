package com.chobo.data.remote.api

import com.chobo.data.remote.dto.order_request.OrderRequestBookType
import com.chobo.data.remote.dto.goal.request.GoalGetRequestBodyGet
import com.chobo.data.remote.dto.goal.response.GoalResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface GoalAPI {
    @POST("/api/v2/goal")
    fun goalPost(
        @Header("Authorization") authorization: String,
    )
    @PATCH("/api/v2/goal/{order_id}")
    fun goalPatch(
        @Header("Authorization") authorization: String,
        @Body body: GoalGetRequestBodyGet,
        @Path("order_id") orderId: String,
        @Query("type") type: OrderRequestBookType
    )
    @GET("/api/v2/goal/{order_id}")
    fun goalDelete(
        @Header("Authorization") authorization: String,
        @Path("order_id") orderId: String
    )
    @GET("/api/v2/goal")
    fun goalGet(
        @Header("RefreshToken") refreshToken: String,
        @Body body: GoalGetRequestBodyGet,
    ): Call<GoalResponse>
}