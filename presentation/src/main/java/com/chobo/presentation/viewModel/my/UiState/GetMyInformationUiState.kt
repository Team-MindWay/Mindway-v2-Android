package com.chobo.presentation.viewModel.my.UiState

import com.chobo.domain.model.my.MyDataModel

sealed interface GetMyInformationUiState {
    object Loading : GetMyInformationUiState
    data class Success(val data: MyDataModel) : GetMyInformationUiState
    data class Fail(val exception: Throwable) : GetMyInformationUiState
}