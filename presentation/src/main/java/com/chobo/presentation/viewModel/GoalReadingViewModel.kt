package com.chobo.presentation.viewModel

import androidx.lifecycle.ViewModel
import com.chobo.presentation.view.main.component.GoalReadingListOfBooksReadItemData
import com.chobo.presentation.view.main.component.ReadingGoalGraphData
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class GoalReadingViewModel @Inject constructor() : ViewModel() {

    private val _goalReadingGraphDataList = (
            listOf(
                ReadingGoalGraphData(1, 3, false, "오"),
                ReadingGoalGraphData(2, 3, true, "늘"),
                ReadingGoalGraphData(1, 3, false, "오"),
                ReadingGoalGraphData(3, 3, false, "오"),
                ReadingGoalGraphData(1, 3, false, "오"),
                ReadingGoalGraphData(3, 3, false, "오"),
                ReadingGoalGraphData(1, 3, false, "오"),
            )
            )
    val goalReadingGraphDataList = _goalReadingGraphDataList

    private val _goalReadingListOfBooksReadItemDataList = (
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
    val goalReadingListOfBooksReadItemDataList = _goalReadingListOfBooksReadItemDataList


    fun plusOnClick() {

    }
}