package com.chobo.presentation.viewModel.main.uistate

import com.chobo.domain.model.goal.GetGoalModel

sealed interface GetGoalUIState {
    object Loading : GetGoalUIState
    object Empty : GetGoalUIState
    data class Success(val data: GetGoalModel) : GetGoalUIState
    data class Fail(val exception: Throwable) : GetGoalUIState
}