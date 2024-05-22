package com.chobo.presentation.viewModel.book.uistate

sealed interface OrderUploadUiState {
    object Loading : OrderUploadUiState
    object Success : OrderUploadUiState
    data class RemoteFail(val exception: Throwable) : OrderUploadUiState
    data class Fail(val exception: Throwable) : OrderUploadUiState
}