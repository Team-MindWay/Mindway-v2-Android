package com.chobo.presentation.viewModel.my.uistate

sealed interface OrderModifyByIdUiState {
    object Loading : OrderModifyByIdUiState
    object Success : OrderModifyByIdUiState
    data class RemoteFail(val exception: Throwable) : OrderModifyByIdUiState
    data class Fail(val exception: Throwable) : OrderModifyByIdUiState
}