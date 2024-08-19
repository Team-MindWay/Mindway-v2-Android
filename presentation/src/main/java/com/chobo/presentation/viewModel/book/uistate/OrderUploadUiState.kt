package com.chobo.presentation.viewModel.book.uistate

sealed interface OrderUploadUiState {
    object Loading : OrderUploadUiState
    object Success : OrderUploadUiState
    object RemoteFail : OrderUploadUiState
    object Fail : OrderUploadUiState
}