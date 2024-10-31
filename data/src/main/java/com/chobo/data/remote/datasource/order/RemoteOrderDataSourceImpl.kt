package com.chobo.data.remote.datasource.order

import com.chobo.data.remote.api.OrderAPI
import com.chobo.data.remote.dto.my_response.MyBookListResponse
import com.chobo.data.remote.dto.order_request.OrderRequestBody
import com.chobo.data.util.performApiRequest
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RemoteOrderDataSourceImpl @Inject constructor(
    private val orderService: OrderAPI,
) : RemoteOrderDataSource {
    override fun orderUpload(body: OrderRequestBody): Flow<Unit> =
        performApiRequest { orderService.orderUpload(body = body) }

    override fun orderModifyById(
        body: MyBookListResponse,
        orderId: Long
    ): Flow<Unit> =
        performApiRequest { orderService.orderModifyById(
            body = body,
            orderId = orderId
        ) }

    override fun orderDeleteById(orderId: Long): Flow<Unit> =
        performApiRequest { orderService.orderDeleteById(orderId = orderId) }
}