package com.chobo.presentation.viewModel

import androidx.lifecycle.ViewModel
import com.chobo.presentation.view.main.component.BookKingOfTheMonthData
import com.chobo.presentation.view.main.component.ReadingGoalGraphData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel() {
    private val _goalBookRead = MutableStateFlow(0)
    val goalBookRead: StateFlow<Int> = _goalBookRead.asStateFlow()

    private val _readingGoalGraphDataList = MutableStateFlow(
            listOf(
                ReadingGoalGraphData(2, 3, false, "일"),
                ReadingGoalGraphData(3, 3, false, "일"),
                ReadingGoalGraphData(2, 3, false, "일"),
                ReadingGoalGraphData(1, 3, true, "일"),
                ReadingGoalGraphData(2, 3, false, "일"),
                ReadingGoalGraphData(1, 3, false, "일"),
                ReadingGoalGraphData(2, 3, false, "일"),
            )
            )
    val readingGoalGraphDataList:StateFlow<List<ReadingGoalGraphData>> = _readingGoalGraphDataList.asStateFlow()

    private val _bookKingOfTheMonthDataList = MutableStateFlow(
            listOf(
                BookKingOfTheMonthData("왕승황", 29),
                BookKingOfTheMonthData("왕성찬", 15),
                BookKingOfTheMonthData("왕지완", 1),
            )
    )
    val bookKingOfTheMonthDataList :StateFlow<List<BookKingOfTheMonthData>> = _bookKingOfTheMonthDataList.asStateFlow()

    private val _titleTextState = MutableStateFlow("가을 독서 행사")
    val titleTextState :StateFlow<String> = _titleTextState.asStateFlow()

    private val _contentTextState = MutableStateFlow("독서의 계절, 가을을 맞아 \n도서관에서 특별한 이벤트를 준비했습니다.")
    val contentTextState :StateFlow<String> = _contentTextState.asStateFlow()

    init {
        _goalBookRead.value = 15
    }
    fun homeNoticeCardOnClick() {

    }

    fun homeGoalReadingChartOnClick(index: Int) {

    }
}