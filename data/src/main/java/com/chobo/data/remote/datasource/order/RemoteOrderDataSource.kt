package com.chobo.data.remote.datasource.order

import com.chobo.data.remote.dto.my_response.MyBookListResponse
import com.chobo.data.remote.dto.order_request.OrderRequestBody
import kotlinx.coroutines.flow.Flow

interface RemoteOrderDataSource {
    suspend fun orderUpload(body: OrderRequestBody): Flow<Unit>
    suspend fun orderModifyById(body: MyBookListResponse, orderId: Long): Flow<Unit>
    suspend fun orderDeleteById(orderId: Long): Flow<Unit>
}