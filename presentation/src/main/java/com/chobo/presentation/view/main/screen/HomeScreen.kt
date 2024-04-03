package com.chobo.presentation.view.main.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chobo.presentation.view.main.component.BookKingOfTheMonthData
import com.chobo.presentation.view.main.component.HomeGoalReadingChart
import com.chobo.presentation.view.main.component.HomeNoticeCard
import com.chobo.presentation.view.main.component.HomeReadersOfTheMonthChart
import com.chobo.presentation.view.main.component.ReadingGoalGraphData

@Composable
fun HomeScreen(

) {
    Column(
        verticalArrangement = Arrangement.spacedBy(20.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp)
    ) {
        HomeNoticeCard(titleText = "가을 독서 행사", content = "독서의 계절, 가을을 맞아 \n도서관에서 특별한 이벤트를 준비했습니다.")
        HomeGoalReadingChart(
            modifier = Modifier.fillMaxWidth().height(211.dp)
            ,
            isHasData = true,
            readNumberList = listOf(
                ReadingGoalGraphData(2, 3, false, "일"),
                ReadingGoalGraphData(3, 3, false, "일"),
                ReadingGoalGraphData(2, 3, false, "일"),
                ReadingGoalGraphData(1, 3, true, "일"),
                ReadingGoalGraphData(2, 3, false, "일"),
                ReadingGoalGraphData(1, 3, false, "일"),
                ReadingGoalGraphData(2, 3, false, "일"),
            ),
            onClick = { MockOnClick() }
        )
        HomeReadersOfTheMonthChart(
            isHasData = true,
            bookKingOfTheMonthData = listOf(
                BookKingOfTheMonthData("왕승황", 29),
                BookKingOfTheMonthData("왕성찬", 15),
                BookKingOfTheMonthData("왕지완", 1),
            )
        )
    }
}

fun MockOnClick() {}

@Preview(showBackground = true)
@Composable
fun HomwScreenPreview() {
    HomeScreen()
}