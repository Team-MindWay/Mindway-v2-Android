package com.chobo.presentation.viewModel.event.uistate

import com.chobo.domain.model.event.response.GetEventListResponseModel
import kotlinx.collections.immutable.ImmutableList

sealed interface GetNowEventListUiState {
    object Loading: GetNowEventListUiState
    object Empty: GetNowEventListUiState
    data class Success(val data: ImmutableList<GetEventListResponseModel>): GetNowEventListUiState
    data class Fail(val exception: Throwable): GetNowEventListUiState
}