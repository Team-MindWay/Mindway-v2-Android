package com.chobo.presentation.viewModel.my.UiState

import com.chobo.domain.model.my.MyBookListModel
import kotlinx.collections.immutable.ImmutableList

sealed interface GetMyBookListUiState {
    object Loading : GetMyBookListUiState
    object Empty : GetMyBookListUiState
    data class Success(val data: ImmutableList<MyBookListModel>) : GetMyBookListUiState
    data class Fail(val exception: Throwable) : GetMyBookListUiState
}