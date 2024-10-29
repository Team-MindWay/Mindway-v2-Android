package com.chobo.domain.usecase.goal

import com.chobo.domain.model.goal.response.GetWeekendGoalModel
import com.chobo.domain.repository.GoalRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetWeekendGoalUseCase @Inject constructor(
    private val goalRepository: GoalRepository
) {
     operator fun invoke(): Flow<GetWeekendGoalModel> =
        goalRepository.getWeekendGoalResponse()
}