package com.chobo.data.repository

import com.chobo.data.remote.datasource.rank.RemoteRankDataSource
import com.chobo.data.remote.dto.rank.toModel
import com.chobo.domain.model.rank.RankModel
import com.chobo.domain.repository.RankRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class RankRepositoryImpl @Inject constructor(
    private val rankDataSource: RemoteRankDataSource
) : RankRepository {
    override suspend fun rankGet(): Flow<List<RankModel>> =
        rankDataSource.rankGet().map { list -> list.map { it.toModel() } }
}