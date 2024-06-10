package com.chobo.presentation.viewModel.my.UiState

import com.chobo.domain.model.my.MyBookListModel

sealed interface GetMyBookListUiState {
    object Loading : GetMyBookListUiState
    object Empty : GetMyBookListUiState
    data class Success(val data: List<MyBookListModel>) : GetMyBookListUiState
    data class Fail(val exception: Throwable) : GetMyBookListUiState
}