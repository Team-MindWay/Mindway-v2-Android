package com.chobo.data.repository

import com.chobo.data.remote.datasource.recommend.RemoteRecommendDataSource
import com.chobo.data.remote.dto.recommend.request.toDto
import com.chobo.data.remote.dto.recommend.response.toModel
import com.chobo.domain.model.recommend.request.RecommendRequestAllModel
import com.chobo.domain.model.recommend.response.RecommendListResponseAllModel
import com.chobo.domain.repository.RecommendRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class RecommendRepositoryImpl @Inject constructor(
    private val remoteRecommendDataSource: RemoteRecommendDataSource
) : RecommendRepository {
    override fun postRecommendBook(
        body: RecommendRequestAllModel,
        type: String
    ): Flow<Unit> =
        remoteRecommendDataSource.postRecommendBook(
            body = body.toDto(),
            type = type
        )

    override fun getRecommendBookList(type: String): Flow<List<RecommendListResponseAllModel>> =
        remoteRecommendDataSource.getRecommendBookList(type = type).map { list -> list.map { it.toModel() } }

    override fun patchRecommendBook(
        body: RecommendRequestAllModel,
        id: Long
    ): Flow<Unit> =
        remoteRecommendDataSource.patchRecommendBook(
            body = body.toDto(),
            id = id
        )

    override fun deleteRecommendBook(id: Long): Flow<Unit> =
        remoteRecommendDataSource.deleteRecommendBook(id = id)
}