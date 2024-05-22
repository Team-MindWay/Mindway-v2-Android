package com.chobo.data.remote.datasource.goal

import com.chobo.data.remote.api.GoalAPI
import com.chobo.data.remote.dto.goal.request.GoalRequestBodyPost
import com.chobo.data.remote.dto.goal.response.GoalWeekendResponse
import com.chobo.data.util.MindWayAPIHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class RemoteGoalDataSourceImpl @Inject constructor(
    private val goalService: GoalAPI
) : RemoteGoalDataSource {
    override suspend fun postGoalRequest(body: GoalRequestBodyPost): Flow<Unit> = flow {
        emit(
            MindWayAPIHandler<Unit>()
                .httpRequest {
                    goalService.postGoal(body = body)
                }
                .sendRequest()
        )
    }.flowOn(Dispatchers.IO)

    override suspend fun getWeekendGoalResponse(): Flow<GoalWeekendResponse> = flow {
        emit(
            MindWayAPIHandler<GoalWeekendResponse>()
                .httpRequest {
                    goalService.getWeekendGoal()
                }
                .sendRequest()
        )
    }.flowOn(Dispatchers.IO)
}