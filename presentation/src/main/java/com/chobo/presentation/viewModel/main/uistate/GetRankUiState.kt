package com.chobo.presentation.viewModel.main.uistate

import com.chobo.domain.model.rank.RankModel
import kotlinx.collections.immutable.ImmutableList

sealed interface GetRankUiState {
    object Loading : GetRankUiState
    object Empty : GetRankUiState
    data class Success(val data: ImmutableList<RankModel>) : GetRankUiState
    object Fail : GetRankUiState
}