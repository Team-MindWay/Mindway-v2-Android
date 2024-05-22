package com.chobo.data.remote.datasource.goal

import com.chobo.data.remote.dto.goal.request.GoalRequestBodyPost
import com.chobo.data.remote.dto.goal.response.GoalWeekendResponse
import kotlinx.coroutines.flow.Flow

interface RemoteGoalDataSource {
    suspend fun postGoalRequest(body: GoalRequestBodyPost): Flow<Unit>

    suspend fun getWeekendGoalResponse(): Flow<GoalWeekendResponse>
}