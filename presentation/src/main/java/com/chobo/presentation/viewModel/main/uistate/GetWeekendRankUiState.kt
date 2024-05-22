package com.chobo.presentation.viewModel.main.uistate

import com.chobo.domain.model.rank.RankModel

sealed interface GetWeekendRankUiState {
    object Loading : GetWeekendRankUiState
    object Empty : GetWeekendRankUiState
    data class Success(val data: List<RankModel>) : GetWeekendRankUiState
    data class Fail(val exception: Throwable) : GetWeekendRankUiState
}