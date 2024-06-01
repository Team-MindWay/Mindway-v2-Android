package com.chobo.data.remote.datasource.order

import com.chobo.data.remote.dto.order_request.OrderRequestBody
import kotlinx.coroutines.flow.Flow

interface RemoteOrderDataSource {
    suspend fun orderUpload(body: OrderRequestBody): Flow<Unit>
    suspend fun orderListGet(): Flow<List<OrderRequestBody>>
    suspend fun orderModifyById(body: OrderRequestBody, orderId: Long): Flow<Unit>
    suspend fun orderDeleteById(orderId: Long): Flow<Unit>
}