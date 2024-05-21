package com.chobo.domain.repository

import com.chobo.domain.model.rank.RankModel
import kotlinx.coroutines.flow.Flow

interface RankRepository {
    suspend fun rankGet(): Flow<RankModel>
}