package com.chobo.data.remote.datasource.recommend

import com.chobo.data.remote.dto.recommend.request.RecommendAllRequest
import com.chobo.data.remote.dto.recommend.response.GetRecommendBookListResponse
import kotlinx.coroutines.flow.Flow

interface RemoteRecommendDataSource {
     fun postRecommendBook(body: RecommendAllRequest, type: String): Flow<Unit>
     fun getRecommendBookList(type: String): Flow<List<GetRecommendBookListResponse>>
     fun patchRecommendBook(body: RecommendAllRequest, id: Long): Flow<Unit>
     fun deleteRecommendBook(id: Long): Flow<Unit>
}