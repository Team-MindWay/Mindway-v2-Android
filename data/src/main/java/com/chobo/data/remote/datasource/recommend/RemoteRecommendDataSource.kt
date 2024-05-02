package com.chobo.data.remote.datasource.recommend

import com.chobo.data.remote.dto.recommend.request.RecommendAllRequest
import com.chobo.data.remote.dto.recommend.response.RecommendAllResponse
import com.chobo.data.remote.enumtype.OrderRequestBookType
import kotlinx.coroutines.flow.Flow

interface RemoteRecommendDataSource {

    suspend fun postRecommendBook(body: RecommendAllRequest, type: OrderRequestBookType): Flow<Unit>
    suspend fun getRecommendBook(type: OrderRequestBookType): Flow<RecommendAllResponse>
    suspend fun patchRecommendBook(body: RecommendAllRequest, id: Long): Flow<Unit>
    suspend fun deleteRecommendBook(id: Long): Flow<Unit>
}