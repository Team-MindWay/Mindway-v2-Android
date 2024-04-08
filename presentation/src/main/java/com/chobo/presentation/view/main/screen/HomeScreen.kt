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
import androidx.lifecycle.viewmodel.compose.viewModel
import com.chobo.presentation.view.main.component.HomeGoalReadingChart
import com.chobo.presentation.view.main.component.HomeNoticeCard
import com.chobo.presentation.view.main.component.HomeReadersOfTheMonthChart
import com.chobo.presentation.viewModel.HomeViewModel

@Composable
fun HomeScreen(
    homeViewModel: HomeViewModel = viewModel()
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(20.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp)
    ) {
        HomeNoticeCard(
            titleText = "가을 독서 행사",
            content = "독서의 계절, 가을을 맞아 \n도서관에서 특별한 이벤트를 준비했습니다.",
            onClick = { homeViewModel.homeNoticeCardOnClick() }
        )
        HomeGoalReadingChart(
            modifier = Modifier
                .fillMaxWidth()
                .height(211.dp),
            isHasData = true,
            readNumberList = homeViewModel.readingGoalGraphDataList,
            onClick = { homeViewModel.homeGoalReadingChartOnClick(1) }
        )
        HomeReadersOfTheMonthChart(
            isHasData = true,
            bookKingOfTheMonthData = homeViewModel.bookKingOfTheMonthDataList
        )
    }
}

fun MockOnClick() {}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}