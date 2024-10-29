package com.chobo.domain.repository

import com.chobo.domain.model.my.MyBookListModel
import com.chobo.domain.model.order.OrderRequestBodyModel
import kotlinx.coroutines.flow.Flow

interface OrderRepository {
     fun orderUpload(body: OrderRequestBodyModel): Flow<Unit>
     fun orderModifyById(body: MyBookListModel, orderId: Long): Flow<Unit>
     fun orderDeleteById(orderId: Long): Flow<Unit>
}