package com.chobo.presentation.viewModel.main.uistate

import com.chobo.domain.model.goal.GoalWeekendResponse

sealed interface GetGoalUIState {
    object Loading : GetGoalUIState
    object Empty : GetGoalUIState
    data class Success(val data: GoalWeekendResponse) : GetGoalUIState
    data class Fail(val exception: Throwable) : GetGoalUIState
}