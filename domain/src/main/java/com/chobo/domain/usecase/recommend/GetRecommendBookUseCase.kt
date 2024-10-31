package com.chobo.domain.usecase.recommend

import com.chobo.domain.model.recommend.response.RecommendListResponseAllModel
import com.chobo.domain.repository.RecommendRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetRecommendBookUseCase @Inject constructor(
    private val recommendRepository: RecommendRepository
) {
    operator fun invoke(type: String) : Flow<List<RecommendListResponseAllModel>> =
        recommendRepository.getRecommendBookList(type = type)
}