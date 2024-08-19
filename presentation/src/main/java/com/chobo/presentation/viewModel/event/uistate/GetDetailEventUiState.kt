package com.chobo.presentation.viewModel.event.uistate

import com.chobo.domain.model.event.response.GetDetailEventResponseModel

sealed interface GetDetailEventUiState {
    object Loading: GetDetailEventUiState
    data class Success(val data: GetDetailEventResponseModel): GetDetailEventUiState
    object Fail: GetDetailEventUiState
}