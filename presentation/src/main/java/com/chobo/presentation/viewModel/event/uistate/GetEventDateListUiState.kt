package com.chobo.presentation.viewModel.event.uistate

import com.chobo.domain.model.event.response.GetEventDateListResponseModel

sealed interface GetEventDateListUiState {
    object Loading: GetEventDateListUiState
    object Empty: GetEventDateListUiState
    data class Success(val getEventDateListResponse: List<GetEventDateListResponseModel>): GetEventDateListUiState
    data class Fail(val exception: Throwable): GetEventDateListUiState
}