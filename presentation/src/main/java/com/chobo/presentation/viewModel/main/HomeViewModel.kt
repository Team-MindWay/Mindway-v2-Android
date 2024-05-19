package com.chobo.presentation.viewModel.main

import androidx.lifecycle.ViewModel
import com.chobo.domain.model.notice.NoticeAllModel
import com.chobo.presentation.view.main.component.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel() {
    private val _goalBookRead = MutableStateFlow(0)
    val goalBookRead: StateFlow<Int> = _goalBookRead.asStateFlow()

    private val _goalReadingGraphDataList = MutableStateFlow<List<GoalReadingGraphData>>(listOf())
    val goalReadingGraphDataList: StateFlow<List<GoalReadingGraphData>> = _goalReadingGraphDataList.asStateFlow()

    private val _bookKingOfTheMonthDataList = MutableStateFlow<List<BookKingOfTheMonthData>>(listOf())
    val bookKingOfTheMonthDataList: StateFlow<List<BookKingOfTheMonthData>> = _bookKingOfTheMonthDataList.asStateFlow()

    private val _noticeData = MutableStateFlow(NoticeAllModel())
    val noticeData: StateFlow<NoticeAllModel> = _noticeData.asStateFlow()

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
        _noticeData.value = NoticeAllModel(title = "가을 독서 행사", content = "독서의 계절, 가을을 맞아 \n도서관에서 특별한 이벤트를 준비했습니다.")
    }
}