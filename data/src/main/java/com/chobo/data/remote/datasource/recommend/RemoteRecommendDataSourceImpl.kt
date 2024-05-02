package com.chobo.data.remote.datasource.recommend

import com.chobo.data.remote.api.RecommendAPI
import com.chobo.data.remote.dto.recommend.request.RecommendAllRequest
import com.chobo.data.remote.dto.recommend.response.GetRecommendBookListResponse
import com.chobo.data.remote.dto.recommend.response.RecommendAllResponse
import com.chobo.data.util.MindWayAPIHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class RemoteRecommendDataSourceImpl @Inject constructor(
    private val recommendService: RecommendAPI
) : RemoteRecommendDataSource {
    override suspend fun postRecommendBook(
        body: RecommendAllRequest,
        type: String
    ): Flow<Unit> = flow {
        emit(
            MindWayAPIHandler<Unit>()
                .httpRequest {
                    recommendService.postRecommendBook(
                        body = body,
                        type = type
                    )
                }
                .sendRequest()
        )
    }.flowOn(Dispatchers.IO)

    override suspend fun getRecommendBookList(type: String): Flow<List<GetRecommendBookListResponse>> = flow {
        emit(
            MindWayAPIHandler<List<GetRecommendBookListResponse>>()
                .httpRequest {
                    recommendService.getRecommendBookList(
                        type = type
                    )
                }
                .sendRequest()
        )
    }.flowOn(Dispatchers.IO)

    override suspend fun patchRecommendBook(body: RecommendAllRequest, id: Long): Flow<Unit> = flow {
        emit(
            MindWayAPIHandler<Unit>()
                .httpRequest {
                    recommendService.patchRecommendBook(
                        body = body,
                        id = id
                    )
                }
                .sendRequest()
        )
    }.flowOn(Dispatchers.IO)

    override suspend fun deleteRecommendBook(id: Long): Flow<Unit> = flow {
        emit(
            MindWayAPIHandler<Unit>()
                .httpRequest {
                    recommendService.deleteRecommendBook(
                        id = id
                    )
                }
                .sendRequest()
        )
    }.flowOn(Dispatchers.IO)
}