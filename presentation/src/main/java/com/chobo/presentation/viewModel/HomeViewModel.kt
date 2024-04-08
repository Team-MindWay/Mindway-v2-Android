package com.chobo.presentation.viewModel

import androidx.lifecycle.ViewModel
import com.chobo.presentation.view.main.component.BookKingOfTheMonthData
import com.chobo.presentation.view.main.component.ReadingGoalGraphData
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel() {
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

    fun homeNoticeCardOnClick() {

    }

    fun homeGoalReadingChartOnClick(index: Int) {

    }
}