package com.chobo.domain.usecase.recommend

import com.chobo.domain.repository.RecommendRepository
import javax.inject.Inject

class DeleteRecommendBookUseCase @Inject constructor(
    private val recommendRepository: RecommendRepository
) {
     operator fun invoke(id: Long) = runCatching {
        recommendRepository.deleteRecommendBook(id = id)
    }
}