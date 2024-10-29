package com.chobo.domain.usecase.recommend

import com.chobo.domain.model.recommend.request.RecommendRequestAllModel
import com.chobo.domain.repository.RecommendRepository
import javax.inject.Inject

class PatchRecommendBookUseCase @Inject constructor(
    private val recommendRepository: RecommendRepository
) {
     operator fun invoke(body: RecommendRequestAllModel, id: Long) = runCatching {
        recommendRepository.patchRecommendBook(
            body = body,
            id = id
        )
    }
}