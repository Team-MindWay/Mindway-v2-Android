package com.chobo.data.repository

import com.chobo.data.remote.datasource.goal.RemoteGoalDataSource
import com.chobo.data.remote.dto.goal.request.toDto
import com.chobo.data.remote.dto.goal.response.toModel
import com.chobo.domain.model.goal.request.PostGoalRequestModel
import com.chobo.domain.model.goal.response.GetWeekendGoalModel
import com.chobo.domain.repository.GoalRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GoalRepositoryImpl @Inject constructor(
    private val remoteGoalDataSource: RemoteGoalDataSource
) : GoalRepository {
    override suspend fun postGoalRequest(body: PostGoalRequestModel): Flow<Unit> =
        remoteGoalDataSource.postGoalRequest(body = body.toDto())

    override suspend fun getWeekendGoalResponse(): Flow<GetWeekendGoalModel> =
        remoteGoalDataSource.getWeekendGoalResponse().map { it.toModel() }
}