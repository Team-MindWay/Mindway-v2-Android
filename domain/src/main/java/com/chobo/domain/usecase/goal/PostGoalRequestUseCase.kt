package com.chobo.domain.usecase.goal

import com.chobo.domain.model.goal.request.PostGoalRequestModel
import com.chobo.domain.repository.GoalRepository
import javax.inject.Inject

class PostGoalRequestUseCase @Inject constructor(
    private val goalRepository: GoalRepository
) {
    suspend operator fun invoke(body: PostGoalRequestModel) = runCatching {
        goalRepository.postGoalRequest(body = body)
    }
}