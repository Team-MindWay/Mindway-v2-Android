package com.chobo.presentation.viewModel

import androidx.lifecycle.ViewModel
import com.chobo.presentation.view.main.component.GoalReadingListOfBooksReadItemData
import com.chobo.presentation.view.main.component.GoalReadingGraphData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class GoalReadingViewModel @Inject constructor() : ViewModel() {
    private val _goalBookRead = MutableStateFlow(0)
    val goalBookRead: StateFlow<Int> = _goalBookRead.asStateFlow()

    private val _goalReadingGraphDataList = MutableStateFlow(
        listOf(
            GoalReadingGraphData(1, 3, false, "오"),
            GoalReadingGraphData(2, 3, true, "늘"),
            GoalReadingGraphData(1, 3, false, "오"),
            GoalReadingGraphData(3, 3, false, "오"),
            GoalReadingGraphData(1, 3, false, "오"),
            GoalReadingGraphData(3, 3, false, "오"),
            GoalReadingGraphData(1, 3, false, "오"),
        )
    )
    val goalReadingGraphDataList: StateFlow<List<GoalReadingGraphData>> = _goalReadingGraphDataList.asStateFlow()

    private val _goalReadingListOfBooksReadItemDataList = MutableStateFlow(
        listOf(
            GoalReadingListOfBooksReadItemData(
                12,
                12,
                "제목",
                "내용입니다 그렇ewjiofhowehfluieifnhcielhuferhwiegir습니다"
            ),
            GoalReadingListOfBooksReadItemData(
                12,
                12,
                "제목",
                "내용renwcilntinhvgdnghrerns입니다 그렇습니다"
            ),
            GoalReadingListOfBooksReadItemData(12, 12, "제목", "내용입니다 그렇습니다"),
            GoalReadingListOfBooksReadItemData(12, 12, "제목", "내용입니다 그렇습니다"),
            GoalReadingListOfBooksReadItemData(
                12,
                12,
                "제목",
                "내용fueiecgkenrgb hefvhjfrhfobhu a boifibdaf hfos hfoshfhdkldu PQWOPSJKFL;JASO UEFIPAJSOIFJ ;ASJF KDJA;FJP[iw jehfuahl;fj;lksjdpoaf jiojf'jwpeoirpanskj vjiocxjnv;jewlj fi0snlfj ajfnlk saklfnsa;lkj vpijcpxbf,wnlfndjakfpzujvo eaoji ofjeio fozisfoizs입니다 그렇습니다"
            )
        )
    )
    val goalReadingListOfBooksReadItemDataList :StateFlow<List<GoalReadingListOfBooksReadItemData>> = _goalReadingListOfBooksReadItemDataList.asStateFlow()

    init {
        _goalBookRead.value = 15
    }

    fun plusOnClick() {

    }
}