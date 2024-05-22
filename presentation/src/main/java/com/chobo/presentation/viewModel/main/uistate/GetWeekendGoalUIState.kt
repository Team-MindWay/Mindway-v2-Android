package com.chobo.presentation.viewModel.main.uistate

import com.chobo.domain.model.goal.response.GetWeekendGoalModel

sealed interface GetWeekendGoalUIState {
    object Loading : GetWeekendGoalUIState
    object Empty : GetWeekendGoalUIState
    data class Success(val data: GetWeekendGoalModel) : GetWeekendGoalUIState
    data class Fail(val exception: Throwable) : GetWeekendGoalUIState
}