package com.chobo.presentation.viewModel.goal.uistate

import com.chobo.domain.model.book.response.BookListResponseModel

sealed interface GetBookListUiState {
    object Loading : GetBookListUiState
    object Empty : GetBookListUiState
    data class Success(val data: List<BookListResponseModel>) : GetBookListUiState
    data class Fail(val exception: Throwable) : GetBookListUiState
}