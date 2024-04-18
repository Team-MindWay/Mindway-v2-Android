package com.chobo.data.remote.api

import com.chobo.data.remote.dto.order_request.OrderRequestBody
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.Path

interface OrderAPI {
    @POST("/api/v2/order")
    suspend fun orderPost(
        @Body body: OrderRequestBody
    )

    @PATCH("/api/v2/order/{order_id}")
    suspend fun orderPatch(
        @Body body: OrderRequestBody,
        @Path("order_id") orderId: String,
    )

    @DELETE("/api/v2/order")
    suspend fun orderDelete()
}