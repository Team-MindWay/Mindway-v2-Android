package com.chobo.data.repository

import com.chobo.data.remote.datasource.recommend.RemoteRecommendDataSource
import com.chobo.data.remote.dto.recommend.request.RecommendAllRequest
import com.chobo.data.remote.dto.recommend.response.toGetRecommendListResponseModel
import com.chobo.domain.model.recommend.request.RecommendRequestAllModel
import com.chobo.domain.model.recommend.response.RecommendListResponseAllModel
import com.chobo.domain.repository.RecommendRepository
import kotlinx.coroutines.flow.*
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

    override suspend fun getRecommendBookList(type: String): Flow<List<RecommendListResponseAllModel>> {
        return remoteRecommendDataSource.getRecommendBookList(type = type).map { list ->
            list.map {
                it.toGetRecommendListResponseModel()
            }
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
        return remoteRecommendDataSource.deleteRecommendBook(id = id)
    }
}