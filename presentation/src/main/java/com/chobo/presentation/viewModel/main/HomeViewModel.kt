package com.chobo.presentation.viewModel.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chobo.domain.usecase.goal.GetWeekendGoalUseCase
import com.chobo.domain.usecase.notice.NoticeGetUseCase
import com.chobo.domain.usecase.rank.GetRankUseCase
import com.chobo.presentation.viewModel.main.uistate.GetRankUiState
import com.chobo.presentation.viewModel.main.uistate.GetWeekendGoalUiState
import com.chobo.presentation.viewModel.main.uistate.NoticeGetUiState
import com.chobo.presentation.viewModel.util.Result
import com.chobo.presentation.viewModel.util.asResult
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
    private val getWeekendGoalUseCase: GetWeekendGoalUseCase
) : ViewModel() {
    private val _getWeekendGoalUiState = MutableStateFlow<GetWeekendGoalUiState>(GetWeekendGoalUiState.Loading)
    val getWeekendGoalUIState: StateFlow<GetWeekendGoalUiState> = _getWeekendGoalUiState.asStateFlow()

    private val _getRankUiState = MutableStateFlow<GetRankUiState>(GetRankUiState.Loading)
    val getRankUIState: StateFlow<GetRankUiState> = _getRankUiState.asStateFlow()

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
                    is Result.Loading -> _getRankUiState.value = GetRankUiState.Loading
                    is Result.Success -> if (result.data.isEmpty()) {
                        _getRankUiState.value = GetRankUiState.Empty
                    } else {
                        _getRankUiState.value = GetRankUiState.Success(result.data)
                    }
                    is Result.Fail -> _getRankUiState.value = GetRankUiState.Fail(result.exception)
                }
            }
    }

    fun getWeekendGoal() = viewModelScope.launch {
        getWeekendGoalUseCase()
            .asResult()
            .collectLatest { result ->
                when (result) {
                    is Result.Loading -> _getWeekendGoalUiState.value = GetWeekendGoalUiState.Loading
                    is Result.Success -> if (result.data.now_count + result.data.goal_value == 0) {
                        _getWeekendGoalUiState.value = GetWeekendGoalUiState.Empty
                    } else {
                        _getWeekendGoalUiState.value = GetWeekendGoalUiState.Success(result.data)
                    }
                    is Result.Fail -> _getWeekendGoalUiState.value = GetWeekendGoalUiState.Fail(result.exception)
                }
            }
    }
}