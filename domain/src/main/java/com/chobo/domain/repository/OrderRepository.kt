package com.chobo.domain.repository

import com.chobo.domain.model.order.OrderRequestBodyModel
import kotlinx.coroutines.flow.Flow

interface OrderRepository {
    suspend fun orderUpload(body: OrderRequestBodyModel): Flow<Unit>
    suspend fun orderListGet(): Flow<List<OrderRequestBodyModel>>
    suspend fun orderModifyById(body: OrderRequestBodyModel, orderId: String): Flow<Unit>
    suspend fun orderDeleteById(orderId: String): Flow<Unit>
}