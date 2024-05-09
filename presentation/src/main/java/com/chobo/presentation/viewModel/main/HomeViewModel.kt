package com.chobo.presentation.viewModel

import androidx.lifecycle.ViewModel
import com.chobo.presentation.view.main.component.BookKingOfTheMonthData
import com.chobo.presentation.view.main.component.GoalReadingGraphData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel() {
    private val _goalBookRead = MutableStateFlow(0)
    val goalBookRead: StateFlow<Int> = _goalBookRead.asStateFlow()

    private val _goalReadingGraphDataList = MutableStateFlow<List<GoalReadingGraphData>>(listOf())
    val goalReadingGraphDataList: StateFlow<List<GoalReadingGraphData>> = _goalReadingGraphDataList.asStateFlow()

    private val _bookKingOfTheMonthDataList = MutableStateFlow<List<BookKingOfTheMonthData>>(listOf())
    val bookKingOfTheMonthDataList: StateFlow<List<BookKingOfTheMonthData>> = _bookKingOfTheMonthDataList.asStateFlow()

    private val _titleTextState = MutableStateFlow("")
    val titleTextState: StateFlow<String> = _titleTextState.asStateFlow()

    private val _contentTextState = MutableStateFlow("")
    val contentTextState: StateFlow<String> = _contentTextState.asStateFlow()

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
        _titleTextState.value = "가을 독서 행사"
        _contentTextState.value = "독서의 계절, 가을을 맞아 \n도서관에서 특별한 이벤트를 준비했습니다."
    }
}