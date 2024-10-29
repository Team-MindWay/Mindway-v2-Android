package com.chobo.domain.repository

import com.chobo.domain.model.goal.request.PostGoalRequestModel
import com.chobo.domain.model.goal.response.GetWeekendGoalModel
import kotlinx.coroutines.flow.Flow

interface GoalRepository {
     fun postGoalRequest(body: PostGoalRequestModel): Flow<Unit>

     fun getWeekendGoalResponse(): Flow<GetWeekendGoalModel>
}