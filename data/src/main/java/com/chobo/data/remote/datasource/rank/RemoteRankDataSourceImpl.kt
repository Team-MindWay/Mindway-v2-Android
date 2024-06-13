package com.chobo.data.remote.datasource.rank

import com.chobo.data.remote.api.RankApi
import com.chobo.data.remote.dto.rank.RankResponse
import com.chobo.data.util.performApiRequest
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RemoteRankDataSourceImpl @Inject constructor(
    private val rankService: RankApi
) : RemoteRankDataSource {
    override suspend fun rankGet(): Flow<List<RankResponse>> = flow {
        performApiRequest { rankService.rankGet() }
    }
}