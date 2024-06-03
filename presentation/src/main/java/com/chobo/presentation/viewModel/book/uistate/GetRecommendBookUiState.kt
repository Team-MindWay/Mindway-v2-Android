package com.chobo.presentation.viewModel.book.uistate

import com.chobo.domain.model.recommend.response.RecommendListResponseAllModel

sealed interface GetRecommendBookUiState {
    object Loading : GetRecommendBookUiState
    object Empty: GetRecommendBookUiState
    data class Success(val data: List<RecommendListResponseAllModel>) : GetRecommendBookUiState
    data class Fail(val exception: Throwable): GetRecommendBookUiState
}