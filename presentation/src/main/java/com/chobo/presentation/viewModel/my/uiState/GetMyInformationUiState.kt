package com.chobo.presentation.viewModel.my.uiState

import com.chobo.domain.model.my.MyDataModel

sealed interface GetMyInformationUiState {
    object Loading : GetMyInformationUiState
    data class Success(val data: MyDataModel) : GetMyInformationUiState
    object Fail : GetMyInformationUiState
}