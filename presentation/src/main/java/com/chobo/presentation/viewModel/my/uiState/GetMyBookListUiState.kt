package com.chobo.presentation.viewModel.my.uiState

import com.chobo.domain.model.my.MyBookListModel
import kotlinx.collections.immutable.ImmutableList

sealed interface GetMyBookListUiState {
    object Loading : GetMyBookListUiState
    object Empty : GetMyBookListUiState
    data class Success(val data: ImmutableList<MyBookListModel>) : GetMyBookListUiState
    object Fail : GetMyBookListUiState
}