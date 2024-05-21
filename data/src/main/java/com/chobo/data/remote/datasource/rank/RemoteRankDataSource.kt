package com.chobo.data.remote.datasource.rank

import com.chobo.data.remote.dto.rank.RankResponse
import kotlinx.coroutines.flow.Flow

interface RemoteRankDataSource {
    suspend fun rankGet(): Flow<RankResponse>
}