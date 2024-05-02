package com.chobo.domain.repository

import com.chobo.domain.model.recommend.request.RecommendRequestAllModel
import com.chobo.domain.model.recommend.response.RecommendResponseAllModel
import kotlinx.coroutines.flow.Flow

interface RecommendRepository {
    suspend fun postRecommendBook(body: RecommendRequestAllModel, type: String): Flow<Unit>
    suspend fun getRecommendBook(type: String): Flow<RecommendResponseAllModel>
    suspend fun patchRecommendBHook(body: RecommendRequestAllModel, id: Long): Flow<Unit>
    suspend fun deleteRecommendBook(id: Long): Flow<Unit>
}