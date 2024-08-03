package com.chobo.presentation.viewModel.event.uistate

import com.chobo.domain.model.event.response.GetEventListResponseModel

interface GetEventListUiState {
    object Loading: GetEventListUiState
    object Empty: GetEventListUiState
    data class Success(val data: List<GetEventListResponseModel>): GetEventListUiState
    data class Fail(val exception: Throwable): GetEventListUiState
}