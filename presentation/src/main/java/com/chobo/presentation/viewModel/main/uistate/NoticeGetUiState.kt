package com.chobo.presentation.viewModel.main.uistate

import com.chobo.domain.model.notice.NoticeAllModel

sealed interface NoticeGetUiState {
    object Loading : NoticeGetUiState
    data class Success(val data: NoticeAllModel) : NoticeGetUiState
    object Fail : NoticeGetUiState
}