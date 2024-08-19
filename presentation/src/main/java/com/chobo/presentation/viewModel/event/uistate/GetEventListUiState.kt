package com.chobo.presentation.viewModel.event.uistate

import com.chobo.domain.model.event.response.GetEventListResponseModel
import kotlinx.collections.immutable.ImmutableList

interface GetEventListUiState {
    object Loading: GetEventListUiState
    object Empty: GetEventListUiState
    data class Success(val data: ImmutableList<GetEventListResponseModel>): GetEventListUiState
    object Fail: GetEventListUiState
}