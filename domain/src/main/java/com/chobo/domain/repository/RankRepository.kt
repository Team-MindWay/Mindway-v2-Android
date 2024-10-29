package com.chobo.domain.repository

import com.chobo.domain.model.rank.RankModel
import kotlinx.coroutines.flow.Flow

interface RankRepository {
     fun rankGet(): Flow<List<RankModel>>
}