package com.chobo.presentation.viewModel.main.uistate

import com.chobo.domain.model.rank.RankModel

sealed interface GetWeekendRankUIState {
    object Loading : GetWeekendRankUIState
    object Empty : GetWeekendRankUIState
    data class Success(val data: List<RankModel>) : GetWeekendRankUIState
    data class Fail(val exception: Throwable) : GetWeekendRankUIState
}