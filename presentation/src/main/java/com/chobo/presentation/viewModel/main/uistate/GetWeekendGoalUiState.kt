package com.chobo.presentation.viewModel.main.uistate

import com.chobo.domain.model.goal.response.GetWeekendGoalModel

sealed interface GetWeekendGoalUiState {
    object Loading : GetWeekendGoalUiState
    object Empty : GetWeekendGoalUiState
    data class Success(val data: GetWeekendGoalModel) : GetWeekendGoalUiState
    data class Fail(val exception: Throwable) : GetWeekendGoalUiState
}