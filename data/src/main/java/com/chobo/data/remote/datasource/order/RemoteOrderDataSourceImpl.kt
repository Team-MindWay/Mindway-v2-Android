package com.chobo.data.remote.datasource.order

import com.chobo.data.remote.api.OrderAPI
import com.chobo.data.remote.dto.order_request.OrderRequestBody
import com.chobo.data.util.MindWayAPIHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class RemoteOrderDataSourceImpl @Inject constructor(
    private val orderAPI: OrderAPI
) : RemoteOrderDataSource {
    override suspend fun orderUpload(body: OrderRequestBody): Flow<Unit> = flow {
        emit(
            MindWayAPIHandler<Unit>()
                .httpRequest { orderAPI.orderUpload(body = body) }
                .sendRequest()
        )
    }.flowOn(Dispatchers.IO)

    override suspend fun orderListGet(): Flow<List<OrderRequestBody>> = flow {
        emit(
            MindWayAPIHandler<List<OrderRequestBody>>()
                .httpRequest { orderAPI.orderListGet() }
                .sendRequest()
        )
    }.flowOn(Dispatchers.IO)

    override suspend fun orderModifyById(body: OrderRequestBody, orderId: Long): Flow<Unit> = flow {
            emit(
                MindWayAPIHandler<Unit>()
                    .httpRequest { orderAPI.orderModifyById(body = body, orderId = orderId) }
                    .sendRequest()
            )
        }.flowOn(Dispatchers.IO)

    override suspend fun orderDeleteById(orderId: Long): Flow<Unit> = flow {
        emit(
            MindWayAPIHandler<Unit>()
                .httpRequest { orderAPI.orderDeleteById(orderId = orderId) }
                .sendRequest()
        )
    }.flowOn(Dispatchers.IO)
}