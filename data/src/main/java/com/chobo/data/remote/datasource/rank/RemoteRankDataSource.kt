package com.chobo.data.remote.datasource.rank

import com.chobo.data.remote.dto.rank.RankResponse
import com.chobo.domain.model.rank.RankModel
import kotlinx.coroutines.flow.Flow

interface RemoteRankDataSource {
    suspend fun rankGet(): Flow<List<RankResponse>>
}