package com.chobo.presentation.viewModel.login.uistate

sealed interface LoginUiState {
    object Loading : LoginUiState
    object Success : LoginUiState
    data class Fail(val exception: Throwable) : LoginUiState
}