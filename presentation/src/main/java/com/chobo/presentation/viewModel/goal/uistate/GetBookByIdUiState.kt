package com.chobo.presentation.viewModel.goal.uistate

import com.chobo.domain.model.book.response.BookListResponseModel

sealed interface GetBookByIdUiState {
    object Loading : GetBookByIdUiState
    data class Success(val data: BookListResponseModel) : GetBookByIdUiState
    data class Fail(val exception: Throwable) : GetBookByIdUiState
}