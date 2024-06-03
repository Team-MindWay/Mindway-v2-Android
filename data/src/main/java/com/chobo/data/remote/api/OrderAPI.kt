package com.chobo.data.remote.api

import com.chobo.data.remote.dto.order_request.OrderRequestBody
import retrofit2.http.*

interface OrderAPI {
    @POST("/api/v2/order")
    suspend fun orderUpload(
        @Body body: OrderRequestBody
    )

    @GET("/api/v2/order")
    suspend fun orderListGet(): List<OrderRequestBody>

    @PATCH("/api/v2/order/{order_id}")
    suspend fun orderModifyById(
        @Body body: OrderRequestBody,
        @Path("order_id") orderId: String,
    )

    @DELETE("/api/v2/order/{order_id}")
    suspend fun orderDeleteById(
        @Path("order_id") orderId: String,
    )
}