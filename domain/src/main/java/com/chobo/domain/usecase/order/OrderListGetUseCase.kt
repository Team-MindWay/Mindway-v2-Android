package com.chobo.domain.usecase.order

import com.chobo.domain.repository.OrderRepository
import javax.inject.Inject

class OrderListGetUseCase @Inject constructor(
    private val orderRepository: OrderRepository
) {
    suspend operator fun invoke() = runCatching {
        orderRepository.orderListGet()
    }
}
