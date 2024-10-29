package com.chobo.data.remote.datasource.goal

import com.chobo.data.remote.api.GoalAPI
import com.chobo.data.remote.dto.goal.request.GoalRequestBodyPost
import com.chobo.data.remote.dto.goal.response.GoalWeekendResponse
import com.chobo.data.util.performApiRequest
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RemoteGoalDataSourceImpl @Inject constructor(
    private val goalService: GoalAPI
) : RemoteGoalDataSource {
    override fun postGoalRequest(body: GoalRequestBodyPost): Flow<Unit> =
        performApiRequest { goalService.postGoal(body = body) }

    override fun getWeekendGoalResponse(): Flow<GoalWeekendResponse> =
        performApiRequest { goalService.getWeekendGoal() }
}