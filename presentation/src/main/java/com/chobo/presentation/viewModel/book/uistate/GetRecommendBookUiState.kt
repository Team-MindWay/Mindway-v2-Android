package com.chobo.presentation.viewModel.book.uistate

import com.chobo.domain.model.recommend.response.RecommendListResponseAllModel

sealed interface GetRecommendBookUiState {
    object Loading : GetRecommendBookUiState
    data class Success(val data: List<RecommendListResponseAllModel>) : GetRecommendBookUiState
    data class Error(val exception: Throwable) : GetRecommendBookUiState
}