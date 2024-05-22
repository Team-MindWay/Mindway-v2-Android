package com.chobo.presentation.viewModel.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chobo.domain.model.goal.GetGoalModel
import com.chobo.domain.usecase.notice.NoticeGetUseCase
import com.chobo.domain.usecase.rank.GetRankUseCase
import com.chobo.presentation.viewModel.main.uistate.GetGoalUIState
import com.chobo.presentation.viewModel.main.uistate.GetRankUIState
import com.chobo.presentation.viewModel.main.uistate.NoticeGetUiState
import com.chobo.presentation.viewModel.util.result.Result
import com.chobo.presentation.viewModel.util.result.asResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getNoticeGetUseCase: NoticeGetUseCase,
    private val getRankUseCase: GetRankUseCase,
) : ViewModel() {
    private val _getGoalUIState = MutableStateFlow<GetGoalUIState>(GetGoalUIState.Loading)
    val getGoalUIState: StateFlow<GetGoalUIState> = _getGoalUIState.asStateFlow()

    private val _getRankUIState = MutableStateFlow<GetRankUIState>(GetRankUIState.Loading)
    val getRankUIState: StateFlow<GetRankUIState> = _getRankUIState.asStateFlow()

    private val _noticeGetUiState = MutableStateFlow<NoticeGetUiState>(NoticeGetUiState.Loading)
    val noticeGetUiState: StateFlow<NoticeGetUiState> = _noticeGetUiState.asStateFlow()

    fun getNotice() = viewModelScope.launch {
        getNoticeGetUseCase()
            .asResult()
            .collectLatest { result ->
                when (result) {
                    is Result.Loading -> _noticeGetUiState.value = NoticeGetUiState.Loading
                    is Result.Success -> _noticeGetUiState.value = NoticeGetUiState.Success(result.data)
                    is Result.Fail -> _noticeGetUiState.value = NoticeGetUiState.Fail(result.exception)
                }
            }
    }

    fun getRank() = viewModelScope.launch {
        getRankUseCase()
            .asResult()
            .collectLatest { result ->
                when (result) {
                    is Result.Loading -> _getRankUIState.value = GetRankUIState.Loading
                    is Result.Success -> if (result.data.isEmpty()) {
                        _getRankUIState.value = GetRankUIState.Empty
                    } else {
                        _getRankUIState.value = GetRankUIState.Success(result.data)
                    }

                    is Result.Fail -> _getRankUIState.value = GetRankUIState.Fail(result.exception)
                }
            }
    }

    init {
        _getGoalUIState.value = GetGoalUIState.Success(
            data = GetGoalModel(
                32, 43, 56, 1, 24, 34, 45, 235, 300
            )
        )
        getRank()
        getNotice()
    }
}