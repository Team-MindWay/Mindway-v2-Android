package com.chobo.domain.usecase.order

import com.chobo.domain.repository.OrderRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class OrderDeleteByIdUseCase @Inject constructor(
    private val orderRepository: OrderRepository,
) {
     operator fun invoke(orderId: Long): Flow<Unit> =
        orderRepository.orderDeleteById(orderId = orderId)
}