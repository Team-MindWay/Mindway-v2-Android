package com.chobo.presentation.viewModel.main.uistate

import com.chobo.domain.model.rank.RankModel

sealed interface GetRankUIState {
    object Loading : GetRankUIState
    object Empty : GetRankUIState
    data class Success(val data: List<RankModel>) : GetRankUIState
    data class Fail(val exception: Throwable) : GetRankUIState
}