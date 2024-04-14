package com.chobo.presentation.viewModel

import androidx.lifecycle.ViewModel
import com.chobo.presentation.view.main.component.GoalReadingListOfBooksReadItemData
import com.chobo.presentation.view.main.component.GoalReadingGraphData
import com.chobo.presentation.view.my.component.MyBookListItemData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class GoalReadingViewModel @Inject constructor() : ViewModel() {
    private val _goalBookRead = MutableStateFlow(0)
    val goalBookRead: StateFlow<Int> = _goalBookRead.asStateFlow()

    private val _goalReadingGraphDataList = MutableStateFlow<List<GoalReadingGraphData>>(listOf())
    val goalReadingGraphDataList: StateFlow<List<GoalReadingGraphData>> =
        _goalReadingGraphDataList.asStateFlow()

    private val _goalReadingListOfBooksReadItemDataList =
        MutableStateFlow<List<GoalReadingListOfBooksReadItemData>>(listOf())
    val goalReadingListOfBooksReadItemDataList: StateFlow<List<GoalReadingListOfBooksReadItemData>> =
        _goalReadingListOfBooksReadItemDataList.asStateFlow()

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
        _goalReadingListOfBooksReadItemDataList.value =
            MutableList(30) {
                GoalReadingListOfBooksReadItemData(
                    12,
                    12,
                    "제목",
                    "내용입니다 그렇ewjiofhowehfluieifnhcielhuferhwiegir습니다"
                )
            }
    }

    fun plusOnClick() {

    }
}