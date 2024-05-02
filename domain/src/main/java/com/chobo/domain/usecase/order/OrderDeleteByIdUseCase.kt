package com.chobo.domain.usecase.order

import com.chobo.domain.repository.OrderRepository
import javax.inject.Inject

class OrderDeleteByIdUseCase @Inject constructor(
    private val orderRepository: OrderRepository
) {
    suspend operator fun invoke(orderId: String) = runCatching {
        orderRepository.orderDeleteById(orderId = orderId)
    }
}