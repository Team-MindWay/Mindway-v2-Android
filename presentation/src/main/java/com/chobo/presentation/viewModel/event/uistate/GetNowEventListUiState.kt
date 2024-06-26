package com.chobo.presentation.viewModel.event.uistate

import com.chobo.domain.model.event.response.GetEventListResponseModel

sealed interface GetNowEventListUiState {
    object Loading: GetNowEventListUiState
    object Empty: GetNowEventListUiState
    data class Success(val getEventListResponse: List<GetEventListResponseModel>): GetNowEventListUiState
    data class Fail(val exception: Throwable): GetNowEventListUiState
}