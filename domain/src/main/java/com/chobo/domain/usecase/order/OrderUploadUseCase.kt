package com.chobo.domain.usecase.order

import com.chobo.domain.model.order.OrderRequestBodyModel
import com.chobo.domain.repository.OrderRepository
import javax.inject.Inject

class OrderUploadUseCase @Inject constructor(
    private val orderRepository: OrderRepository
) {
     operator fun invoke(body: OrderRequestBodyModel) = runCatching {
        orderRepository.orderUpload(body = body)
    }
}