package com.chobo.domain.usecase.goal

import com.chobo.domain.model.goal.request.PostGoalRequestModel
import com.chobo.domain.repository.GoalRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PostGoalRequestUseCase @Inject constructor(
    private val goalRepository: GoalRepository
) {
     operator fun invoke(body: PostGoalRequestModel) :Flow<Unit> =
        goalRepository.postGoalRequest(body = body)
}