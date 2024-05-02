package com.chobo.data.repository

import com.chobo.data.remote.datasource.recommend.RemoteRecommendDataSource
import com.chobo.data.remote.dto.recommend.request.RecommendAllRequest
import com.chobo.data.remote.dto.recommend.response.toAllRecommendResponseModel
import com.chobo.domain.model.recommend.request.RecommendRequestAllModel
import com.chobo.domain.model.recommend.response.RecommendResponseAllModel
import com.chobo.domain.repository.RecommendRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class RecommendRepositoryImpl @Inject constructor(
    private val remoteRecommendDataSource: RemoteRecommendDataSource
) : RecommendRepository {
    override suspend fun postRecommendBook(
        body: RecommendRequestAllModel,
        type: String
    ): Flow<Unit> {
        return remoteRecommendDataSource.postRecommendBook(
            body = RecommendAllRequest(
                title = body.title,
                content = body.content,
                author = body.author
            ),
            type = type
        )
    }

    override suspend fun getRecommendBook(type: String): Flow<RecommendResponseAllModel> {
        return remoteRecommendDataSource.getRecommendBook(
            type = type
        ).map {
            it.toAllRecommendResponseModel()
        }
    }

    override suspend fun patchRecommendBook(body: RecommendRequestAllModel, id: Long): Flow<Unit> {
        return remoteRecommendDataSource.patchRecommendBook(
            body = RecommendAllRequest(
                title = body.title,
                content = body.content,
                author = body.author
            ),
            id = id
        )
    }

    override suspend fun deleteRecommendBook(id: Long): Flow<Unit> {
        return remoteRecommendDataSource.deleteRecommendBook(
            id = id
        )
    }
}