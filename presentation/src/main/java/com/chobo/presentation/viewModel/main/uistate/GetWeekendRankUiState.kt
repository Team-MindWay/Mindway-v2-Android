package com.chobo.presentation.viewModel.main.uistate

import com.chobo.domain.model.rank.RankModel
import kotlinx.collections.immutable.ImmutableList

sealed interface GetWeekendRankUiState {
    object Loading : GetWeekendRankUiState
    object Empty : GetWeekendRankUiState
    data class Success(val data: ImmutableList<RankModel>) : GetWeekendRankUiState
    data class Fail(val exception: Throwable) : GetWeekendRankUiState
}