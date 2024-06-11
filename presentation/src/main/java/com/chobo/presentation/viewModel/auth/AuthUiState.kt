package com.chobo.presentation.viewModel.auth

sealed interface AuthUiState {
    object Loading : AuthUiState
    object Success : AuthUiState
    data class Fail(val exception: Throwable) : AuthUiState
}