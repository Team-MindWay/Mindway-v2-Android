package com.chobo.data.remote.datasource.order

import com.chobo.data.remote.dto.order_request.OrderRequestBody
import kotlinx.coroutines.flow.Flow

interface RemoteOrderDataSource {
    suspend fun orderUpload(body: OrderRequestBody): Flow<Unit>
    suspend fun orderModifyById(body: OrderRequestBody, orderId: Long): Flow<Unit>
}