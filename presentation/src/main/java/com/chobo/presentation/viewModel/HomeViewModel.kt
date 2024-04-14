package com.chobo.presentation.viewModel

import androidx.lifecycle.ViewModel
import com.chobo.presentation.view.main.component.BookKingOfTheMonthData
import com.chobo.presentation.view.main.component.ReadingGoalGraphData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel() {
    private val _goalBookRead = MutableStateFlow(0)
    init {
        _goalBookRead.value = 15
    }
    val goalBookRead: StateFlow<Int>
        get() = _goalBookRead

    private val _readingGoalGraphDataList = (
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
    val readingGoalGraphDataList = _readingGoalGraphDataList

    private val _bookKingOfTheMonthDataList = (
            listOf(
                BookKingOfTheMonthData("왕승황", 29),
                BookKingOfTheMonthData("왕성찬", 15),
                BookKingOfTheMonthData("왕지완", 1),
            )
    )
    val bookKingOfTheMonthDataList = _bookKingOfTheMonthDataList

    private val _titleState = MutableStateFlow("가을 독서 행사")

    private val _contentState = MutableStateFlow("독서의 계절, 가을을 맞아 \n도서관에서 특별한 이벤트를 준비했습니다.")

    fun returnTitleText():String{
        return _titleState.value
    }
    fun returnContentText():String{
        return _contentState.value
    }

    fun homeNoticeCardOnClick() {

    }

    fun homeGoalReadingChartOnClick(index: Int) {

    }
}