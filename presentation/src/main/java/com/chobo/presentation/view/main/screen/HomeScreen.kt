package com.chobo.presentation.view.main.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.navigation.compose.rememberNavController
import com.chobo.presentation.view.event.navigation.navigationToDetailEvent
import com.chobo.presentation.view.main.component.HomeGoalReadingChart
import com.chobo.presentation.view.main.component.HomeNoticeCard
import com.chobo.presentation.view.main.component.HomeReadersOfTheMonthChart
import com.chobo.presentation.view.main.navigation.navigationToGoalReading
import com.chobo.presentation.viewModel.HomeViewModel

@Composable
fun HomeScreen(
    homeViewModel: HomeViewModel = viewModel(),
    navigateToGoalReading: () -> Unit,
    navigateToDetailEvent: () -> Unit,
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(20.dp, Alignment.Top),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp)
    ) {
        HomeNoticeCard(
            titleText = homeViewModel.returnTitleText(),
            content = homeViewModel.returnContentText(),
            onClick = navigateToDetailEvent
        )
        HomeGoalReadingChart(
            modifier = Modifier
                .fillMaxWidth()
                .height(211.dp),
            isHasData = true,
            readNumberList = homeViewModel.readingGoalGraphDataList,
            onClick = navigateToGoalReading
        )
        HomeReadersOfTheMonthChart(
            isHasData = true,
            bookKingOfTheMonthData = homeViewModel.bookKingOfTheMonthDataList
        )
    }
}
@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(
        navigateToGoalReading = { },
        navigateToDetailEvent = { }
    )
}