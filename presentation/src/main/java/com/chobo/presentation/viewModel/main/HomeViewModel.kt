package com.chobo.presentation.viewModel.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chobo.domain.usecase.notice.NoticeGetUseCase
import com.chobo.presentation.view.main.component.BookKingOfTheMonthData
import com.chobo.presentation.view.main.component.GoalReadingGraphData
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
    private val getNoticeGetUseCase: NoticeGetUseCase
) : ViewModel() {
    private val _goalBookRead = MutableStateFlow(0)
    val goalBookRead: StateFlow<Int> = _goalBookRead.asStateFlow()

    private val _goalReadingGraphDataList = MutableStateFlow<List<GoalReadingGraphData>>(listOf())
    val goalReadingGraphDataList: StateFlow<List<GoalReadingGraphData>> = _goalReadingGraphDataList.asStateFlow()

    private val _bookKingOfTheMonthDataList = MutableStateFlow<List<BookKingOfTheMonthData>>(listOf())
    val bookKingOfTheMonthDataList: StateFlow<List<BookKingOfTheMonthData>> = _bookKingOfTheMonthDataList.asStateFlow()

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

    init {
        _goalBookRead.value = 15
        _goalReadingGraphDataList.value = listOf(
            GoalReadingGraphData(2, 3, false, "일"),
            GoalReadingGraphData(3, 3, false, "일"),
            GoalReadingGraphData(2, 3, false, "일"),
            GoalReadingGraphData(1, 3, true, "일"),
            GoalReadingGraphData(2, 3, false, "일"),
            GoalReadingGraphData(1, 3, false, "일"),
            GoalReadingGraphData(2, 3, false, "일"),
        )
        _bookKingOfTheMonthDataList.value = listOf(
            BookKingOfTheMonthData("왕승황", 29),
            BookKingOfTheMonthData("왕성찬", 15),
            BookKingOfTheMonthData("왕지완", 1),
        )
        getNotice()
    }
}