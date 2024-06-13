package com.chobo.data.repository

import com.chobo.data.remote.datasource.order.RemoteOrderDataSource
import com.chobo.data.remote.dto.my_response.toDto
import com.chobo.data.remote.dto.order_request.toDto
import com.chobo.domain.model.my.MyBookListModel
import com.chobo.domain.model.order.OrderRequestBodyModel
import com.chobo.domain.repository.OrderRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class OrderRepositoryImpl @Inject constructor(
    private val remoteNoticeDataSource: RemoteOrderDataSource
) : OrderRepository {
    override suspend fun orderUpload(body: OrderRequestBodyModel): Flow<Unit> =
        remoteNoticeDataSource.orderUpload(body = body.toDto())

    override suspend fun orderModifyById(
        body: MyBookListModel,
        orderId: Long
    ): Flow<Unit> =
        remoteNoticeDataSource.orderModifyById(
            body = body.toDto(),
            orderId = orderId
        )

    override suspend fun orderDeleteById(orderId: Long): Flow<Unit> =
        remoteNoticeDataSource.orderDeleteById(orderId = orderId)
}