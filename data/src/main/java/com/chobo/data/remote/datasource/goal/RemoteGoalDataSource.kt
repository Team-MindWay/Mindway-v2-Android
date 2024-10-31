package com.chobo.data.remote.datasource.goal

import com.chobo.data.remote.dto.goal.request.GoalRequestBodyPost
import com.chobo.data.remote.dto.goal.response.GoalWeekendResponse
import kotlinx.coroutines.flow.Flow

interface RemoteGoalDataSource {
     fun postGoalRequest(body: GoalRequestBodyPost): Flow<Unit>

     fun getWeekendGoalResponse(): Flow<GoalWeekendResponse>
}