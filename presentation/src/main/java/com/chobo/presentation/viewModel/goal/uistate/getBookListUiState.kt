package com.chobo.presentation.viewModel.goal.uistate

import com.chobo.domain.model.book.response.BookListResponseModel
import kotlinx.collections.immutable.ImmutableList

sealed interface GetBookListUiState {
    object Loading : GetBookListUiState
    object Empty : GetBookListUiState
    data class Success(val data: ImmutableList<BookListResponseModel>) : GetBookListUiState
    object Fail : GetBookListUiState
}