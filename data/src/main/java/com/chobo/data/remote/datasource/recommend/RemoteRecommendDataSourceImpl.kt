package com.chobo.data.remote.datasource.recommend

import com.chobo.data.remote.api.RecommendAPI
import com.chobo.data.remote.dto.recommend.request.RecommendAllRequest
import com.chobo.data.remote.dto.recommend.response.RecommendAllResponse
import com.chobo.data.remote.enumtype.OrderRequestBookType
import com.chobo.data.util.MindWayAPIHandler
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RemoteRecommendDataSourceImpl @Inject constructor(
    private val recommendService: RecommendAPI
) : RemoteRecommendDataSource {
    override suspend fun postRecommendBook(
        body: RecommendAllRequest,
        type: OrderRequestBookType
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
    }

    override suspend fun getRecommendBook(type: OrderRequestBookType): Flow<RecommendAllResponse> = flow {
        emit(
            MindWayAPIHandler<RecommendAllResponse>()
                .httpRequest {
                    recommendService.getRecommendBook(
                        type = type
                    )
                }
                .sendRequest()
        )
    }

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
    }

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
    }
}