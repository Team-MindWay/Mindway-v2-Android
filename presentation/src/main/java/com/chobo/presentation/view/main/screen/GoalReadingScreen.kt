package com.chobo.presentation.view.main.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.lifecycle.viewmodel.compose.viewModel
import com.chobo.presentation.view.main.component.GoalReadingChart
import com.chobo.presentation.view.main.component.GoalReadingListOfBooksReadItem
import com.chobo.presentation.view.main.component.GoalReadingPlusCard
import com.chobo.presentation.view.main.component.ReadingGoalGraphData
import com.chobo.presentation.viewModel.GoalReadingViewModel

@Composable
fun GoalReadingScreen(
    goalReadingViewModel: GoalReadingViewModel = viewModel()
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
        Column(
            verticalArrangement = Arrangement.spacedBy(20.dp, Alignment.Top),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(20.dp, Alignment.Top),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                item {
                    GoalReadingChart(
                        isHasData = true,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(180.dp),
                        readingGoalGraphData = goalReadingViewModel.goalReadingGraphDataList.map { data ->
                            ReadingGoalGraphData(
                                numBooksRead = data.numBooksRead,
                                maxBooksRead = data.maxBooksRead,
                                isCurrentDate = data.isCurrentDate,
                                today = data.today
                            )
                        }
                    )
                }
                item {
                    GoalReadingPlusCard(onClick = { goalReadingViewModel.plusOnClick() })
                }
                items(goalReadingViewModel.goalReadingListOfBooksReadItemDataList) { item ->
                    GoalReadingListOfBooksReadItem(data = item) {
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GoalReadingScreenPreview(
) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        GoalReadingScreen()
    }
}