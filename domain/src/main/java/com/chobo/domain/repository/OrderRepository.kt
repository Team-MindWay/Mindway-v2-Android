package com.chobo.domain.repository

import com.chobo.domain.model.order.OrderRequestBodyModel
import kotlinx.coroutines.flow.Flow

interface OrderRepository {
    suspend fun orderUpload(body: OrderRequestBodyModel): Flow<Unit>
    suspend fun orderModifyById(body: OrderRequestBodyModel, orderId: Long): Flow<Unit>
}