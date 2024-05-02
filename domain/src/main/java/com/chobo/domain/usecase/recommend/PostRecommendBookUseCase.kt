package com.chobo.domain.usecase.recommend

import com.chobo.domain.model.recommend.request.RecommendRequestAllModel
import com.chobo.domain.repository.RecommendRepository
import javax.inject.Inject

class PostRecommendBookUseCase @Inject constructor(
    private val recommendRepository: RecommendRepository
) {
    suspend operator fun invoke(body: RecommendRequestAllModel, type: String) = runCatching {
        recommendRepository.postRecommendBook(
            body = body,
            type = type
        )
    }
}