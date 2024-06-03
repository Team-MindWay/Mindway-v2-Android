package com.chobo.domain.usecase.order

import com.chobo.domain.model.order.OrderRequestBodyModel
import com.chobo.domain.repository.OrderRepository
import javax.inject.Inject

class OrderModifyByIdUseCase @Inject constructor(
    private val orderRepository: OrderRepository
) {
    suspend operator fun invoke(body: OrderRequestBodyModel, orderId: String) = runCatching {
        orderRepository.orderModifyById(body = body, orderId = orderId)
    }
}