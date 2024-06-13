package com.chobo.presentation.viewModel.goal.uistate

import com.chobo.domain.model.book.request.BookRequestBodyModel

sealed interface GetBookByIdUiState {
    object Loading : GetBookByIdUiState
    data class Success(val data: BookRequestBodyModel) : GetBookByIdUiState
    data class Fail(val exception: Throwable) : GetBookByIdUiState
}