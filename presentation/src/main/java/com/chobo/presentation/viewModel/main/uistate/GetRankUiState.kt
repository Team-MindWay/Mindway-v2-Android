package com.chobo.presentation.viewModel.main.uistate

import com.chobo.domain.model.rank.RankModel

sealed interface GetRankUiState {
    object Loading : GetRankUiState
    object Empty : GetRankUiState
    data class Success(val data: List<RankModel>) : GetRankUiState
    data class Fail(val exception: Throwable) : GetRankUiState
}