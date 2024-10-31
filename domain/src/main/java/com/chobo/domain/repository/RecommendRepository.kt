package com.chobo.domain.repository

import com.chobo.domain.model.recommend.request.RecommendRequestAllModel
import com.chobo.domain.model.recommend.response.RecommendListResponseAllModel
import kotlinx.coroutines.flow.Flow

interface RecommendRepository {
     fun postRecommendBook(body: RecommendRequestAllModel, type: String): Flow<Unit>
     fun getRecommendBookList(type: String): Flow<List<RecommendListResponseAllModel>>
     fun patchRecommendBook(body: RecommendRequestAllModel, id: Long): Flow<Unit>
     fun deleteRecommendBook(id: Long): Flow<Unit>
}