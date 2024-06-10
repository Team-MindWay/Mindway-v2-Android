package com.chobo.data.repository

import com.chobo.data.remote.datasource.order.RemoteOrderDataSource
import com.chobo.data.remote.dto.order_request.toDto
import com.chobo.domain.model.order.OrderRequestBodyModel
import com.chobo.domain.repository.OrderRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class OrderRepositoryImpl @Inject constructor(
    private val remoteNoticeDataSource: RemoteOrderDataSource
) : OrderRepository {
    override suspend fun orderUpload(body: OrderRequestBodyModel): Flow<Unit> {
        return remoteNoticeDataSource.orderUpload(body = body.toDto())
    }

    override suspend fun orderModifyById(body: OrderRequestBodyModel, orderId: Long): Flow<Unit> {
        return remoteNoticeDataSource.orderModifyById(body = body.toDto(), orderId = orderId)
    }

    override suspend fun orderDeleteById(orderId: Long): Flow<Unit> {
        return remoteNoticeDataSource.orderDeleteById(orderId = orderId)
    }
}