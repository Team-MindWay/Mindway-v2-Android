package com.chobo.data.remote.datasource.rank

import com.chobo.data.remote.api.RankApi
import com.chobo.data.remote.dto.rank.RankResponse
import com.chobo.data.util.MindWayAPIHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class RemoteRankDataSourceImpl @Inject constructor(
    private val rankApi: RankApi
) : RemoteRankDataSource {
    override suspend fun rankGet(): Flow<RankResponse> = flow {
        emit(
            MindWayAPIHandler<RankResponse>()
                .httpRequest { rankApi.rankGet() }
                .sendRequest()
        )
    }.flowOn(Dispatchers.IO)
}