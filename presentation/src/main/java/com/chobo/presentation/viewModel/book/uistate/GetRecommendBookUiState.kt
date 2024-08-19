package com.chobo.presentation.viewModel.book.uistate

import com.chobo.domain.model.recommend.response.RecommendListResponseAllModel
import kotlinx.collections.immutable.ImmutableList

sealed interface GetRecommendBookUiState {
    object Loading : GetRecommendBookUiState
    object Empty: GetRecommendBookUiState
    data class Success(val data: ImmutableList<RecommendListResponseAllModel>) : GetRecommendBookUiState
    object Fail: GetRecommendBookUiState
}