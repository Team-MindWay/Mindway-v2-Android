package com.chobo.presentation.viewModel.event.uistate

import com.chobo.domain.model.event.response.GetEventListResponseModel
import kotlinx.collections.immutable.ImmutableList

interface GetPastEventListUiState {
    object Loading: GetPastEventListUiState
    object Empty: GetPastEventListUiState
    data class Success(val data: ImmutableList<GetEventListResponseModel>): GetPastEventListUiState
    data class Fail(val exception: Throwable): GetPastEventListUiState
}