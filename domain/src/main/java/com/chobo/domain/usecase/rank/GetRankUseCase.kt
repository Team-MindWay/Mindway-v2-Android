package com.chobo.domain.usecase.rank

import com.chobo.domain.model.rank.RankModel
import com.chobo.domain.repository.RankRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetRankUseCase @Inject constructor(
    private val rankRepository: RankRepository
) {
     operator fun invoke(): Flow<List<RankModel>> =
        rankRepository.rankGet()
}