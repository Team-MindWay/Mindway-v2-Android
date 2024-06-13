package com.chobo.data.remote.datasource.recommend

import com.chobo.data.remote.api.RecommendAPI
import com.chobo.data.remote.dto.recommend.request.RecommendAllRequest
import com.chobo.data.remote.dto.recommend.response.GetRecommendBookListResponse
import com.chobo.data.util.performApiRequest
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RemoteRecommendDataSourceImpl @Inject constructor(
    private val recommendService: RecommendAPI
) : RemoteRecommendDataSource {
    override suspend fun postRecommendBook(body: RecommendAllRequest, type: String): Flow<Unit> = flow {
        performApiRequest { recommendService.postRecommendBook(body = body, type = type) }
    }

    override suspend fun getRecommendBookList(type: String): Flow<List<GetRecommendBookListResponse>> = flow {
        performApiRequest { recommendService.getRecommendBookList(type = type) }
    }

    override suspend fun patchRecommendBook(body: RecommendAllRequest, id: Long): Flow<Unit> = flow {
        performApiRequest { recommendService.patchRecommendBook(body = body, id = id) }
    }

    override suspend fun deleteRecommendBook(id: Long): Flow<Unit> = flow {
        performApiRequest { recommendService.deleteRecommendBook(id = id) }
    }
}