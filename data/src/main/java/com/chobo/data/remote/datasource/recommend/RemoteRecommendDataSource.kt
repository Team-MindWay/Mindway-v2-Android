package com.chobo.data.remote.datasource.recommend

import com.chobo.data.remote.dto.recommend.request.RecommendAllRequest
import com.chobo.data.remote.dto.recommend.response.GetRecommendBookListResponse
import kotlinx.coroutines.flow.Flow

interface RemoteRecommendDataSource {

    suspend fun postRecommendBook(body: RecommendAllRequest, type: String): Flow<Unit>
    suspend fun getRecommendBookList(type: String): Flow<List<GetRecommendBookListResponse>>
    suspend fun patchRecommendBook(body: RecommendAllRequest, id: Long): Flow<Unit>
    suspend fun deleteRecommendBook(id: Long): Flow<Unit>
}