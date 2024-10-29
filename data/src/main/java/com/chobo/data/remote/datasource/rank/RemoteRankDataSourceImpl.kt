package com.chobo.data.remote.datasource.rank

import com.chobo.data.remote.api.RankApi
import com.chobo.data.remote.dto.rank.RankResponse
import com.chobo.data.util.performApiRequest
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RemoteRankDataSourceImpl @Inject constructor(
    private val rankService: RankApi
) : RemoteRankDataSource {
    override fun rankGet(): Flow<List<RankResponse>> =
        performApiRequest { rankService.rankGet() }
}