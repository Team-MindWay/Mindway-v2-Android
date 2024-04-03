package com.chobo.presentation.view.main.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chobo.presentation.view.main.component.GoalReadingChart
import com.chobo.presentation.view.main.component.GoalReadingListOfBooksReadItem
import com.chobo.presentation.view.main.component.GoalReadingListOfBooksReadItemData
import com.chobo.presentation.view.main.component.GoalReadingPlusCard
import com.chobo.presentation.view.main.component.ReadingGoalGraphData

@Composable
fun GoalReadingScreen(
    goalReadingListOfBooksReadItemDataList: List<GoalReadingListOfBooksReadItemData>,
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(20.dp, Alignment.Top),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(
                start = 24.dp,
                end = 24.dp,
                top = 12.dp,
            )
            .fillMaxSize()
    ) {
        GoalReadingChart(
            isHasData = true,
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp),
            readNumberList = listOf(
                ReadingGoalGraphData(1, 3, false, "오"),
                ReadingGoalGraphData(2, 3, true, "늘"),
                ReadingGoalGraphData(1, 3, false, "오"),
                ReadingGoalGraphData(3, 3, false, "오"),
                ReadingGoalGraphData(1, 3, false, "오"),
                ReadingGoalGraphData(3, 3, false, "오"),
                ReadingGoalGraphData(1, 3, false, "오"),
            )
        )
        Column(
            verticalArrangement = Arrangement.spacedBy(20.dp, Alignment.Top),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
        ) {
            GoalReadingPlusCard {}
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(20.dp, Alignment.Top),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                items(goalReadingListOfBooksReadItemDataList) { item ->
                    GoalReadingListOfBooksReadItem(data = item) {
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GoalReadingScreenView(
) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        GoalReadingScreen(listOf(GoalReadingListOfBooksReadItemData(12, 12, "제목", "내용입니다 그렇ewjiofhowehfluieifnhcielhuferhwiegir습니다"),GoalReadingListOfBooksReadItemData(12, 12, "제목", "내용renwcilntinhvgdnghrerns입니다 그렇습니다"),GoalReadingListOfBooksReadItemData(12, 12, "제목", "내용입니다 그렇습니다"),GoalReadingListOfBooksReadItemData(12, 12, "제목", "내용입니다 그렇습니다"),GoalReadingListOfBooksReadItemData(12, 12, "제목", "내용fueiecgkenrgb hefvhjfrhfobhu a boifibdaf hfos hfoshfhdkldu PQWOPSJKFL;JASO UEFIPAJSOIFJ ;ASJF KDJA;FJP[iw jehfuahl;fj;lksjdpoaf jiojf'jwpeoirpanskj vjiocxjnv;jewlj fi0snlfj ajfnlk saklfnsa;lkj vpijcpxbf,wnlfndjakfpzujvo eaoji ofjeio fozisfoizs입니다 그렇습니다")))
    }
}