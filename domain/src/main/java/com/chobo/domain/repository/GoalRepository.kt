package com.chobo.domain.repository

import com.chobo.domain.model.goal.request.PostGoalRequestModel
import com.chobo.domain.model.goal.response.GetWeekendGoalModel
import kotlinx.coroutines.flow.Flow

interface GoalRepository {
    suspend fun postGoalRequest(body: PostGoalRequestModel): Flow<Unit>

    suspend fun getWeekendGoalResponse(): Flow<GetWeekendGoalModel>
}