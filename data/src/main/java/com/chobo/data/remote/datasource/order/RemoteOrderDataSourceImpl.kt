package com.chobo.data.remote.datasource.order

import com.chobo.data.remote.api.OrderAPI
import com.chobo.data.remote.dto.my_response.MyBookListResponse
import com.chobo.data.remote.dto.order_request.OrderRequestBody
import com.chobo.data.util.performApiRequest
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RemoteOrderDataSourceImpl @Inject constructor(
    private val orderService: OrderAPI,
) : RemoteOrderDataSource {
    override suspend fun orderUpload(body: OrderRequestBody): Flow<Unit> = flow {
        performApiRequest { orderService.orderUpload(body = body) }
    }

    override suspend fun orderModifyById(body: MyBookListResponse, orderId: Long): Flow<Unit> = flow {
        performApiRequest { orderService.orderModifyById(body = body, orderId = orderId) }
    }

    override suspend fun orderDeleteById(orderId: Long): Flow<Unit> = flow {
        performApiRequest { orderService.orderDeleteById(orderId = orderId) }
    }
}