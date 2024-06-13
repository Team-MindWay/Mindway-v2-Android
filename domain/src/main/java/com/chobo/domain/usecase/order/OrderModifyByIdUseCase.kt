package com.chobo.domain.usecase.order

import com.chobo.domain.model.my.MyBookListModel
import com.chobo.domain.model.order.OrderRequestBodyModel
import com.chobo.domain.repository.OrderRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class OrderModifyByIdUseCase @Inject constructor(
    private val orderRepository: OrderRepository,
) {
    suspend operator fun invoke(body: MyBookListModel, orderId: Long): Flow<Unit> =
        orderRepository.orderModifyById(body = body, orderId = orderId)
}