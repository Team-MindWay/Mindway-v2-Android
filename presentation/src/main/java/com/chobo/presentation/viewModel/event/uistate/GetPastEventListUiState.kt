package com.chobo.presentation.viewModel.event.uistate

import com.chobo.domain.model.event.response.GetEventListResponseModel

interface GetPastEventListUiState {
    object Loading: GetPastEventListUiState
    object Empty: GetPastEventListUiState
    data class Success(val getEventListResponse: List<GetEventListResponseModel>): GetPastEventListUiState
    data class Fail(val exception: Throwable): GetPastEventListUiState
}