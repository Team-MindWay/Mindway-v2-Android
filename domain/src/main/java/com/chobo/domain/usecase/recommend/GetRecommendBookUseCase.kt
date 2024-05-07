package com.chobo.domain.usecase.recommend

import com.chobo.domain.repository.RecommendRepository
import javax.inject.Inject

class GetRecommendBookUseCase @Inject constructor(
    private val recommendRepository: RecommendRepository
) {
    suspend operator fun invoke(type: String) = runCatching {
        recommendRepository.getRecommendBookList(type = type)
    }
}