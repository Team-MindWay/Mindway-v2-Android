package com.chobo.presentation.view.main.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.chobo.presentation.view.component.icon.LogoIcon
import com.chobo.presentation.view.component.topBar.MindWayTopAppBar
import com.chobo.presentation.view.main.component.HomeGoalReadingChart
import com.chobo.presentation.view.main.component.HomeNoticeCard
import com.chobo.presentation.view.main.component.HomeReadersOfTheMonthChart
import com.chobo.presentation.view.theme.MindWayAndroidTheme
import com.chobo.presentation.viewModel.HomeViewModel

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    homeViewModel: HomeViewModel = viewModel(),
    navigateToGoalReading: () -> Unit,
    navigateToDetailEvent: () -> Unit,
) {
    val titleTextState by homeViewModel.titleTextState.collectAsState()
    val contentTextState by homeViewModel.contentTextState.collectAsState()
    val goalBookRead by homeViewModel.goalBookRead.collectAsState()
    val readingGoalGraphDataList by homeViewModel.goalReadingGraphDataList.collectAsState()
    val bookKingOfTheMonthDataList by homeViewModel.bookKingOfTheMonthDataList.collectAsState()

    MindWayAndroidTheme { colors, _ ->
        Column {
            MindWayTopAppBar(startIcon = { LogoIcon() })
            Column(
                verticalArrangement = Arrangement.spacedBy(20.dp, Alignment.Top),
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = modifier
                    .background(color = colors.WHITE)
                    .fillMaxSize()
                    .padding(horizontal = 24.dp)
            ) {
                HomeNoticeCard(
                    titleText = titleTextState,
                    content = contentTextState,
                    onClick = navigateToDetailEvent,
                    modifier = Modifier
                        .height(100.dp)
                        .fillMaxWidth(),
                )
                HomeGoalReadingChart(
                    readNumberList = readingGoalGraphDataList,
                    onClick = navigateToGoalReading,
                    goalBookRead = goalBookRead,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(211.dp),
                )
                HomeReadersOfTheMonthChart(
                    bookKingOfTheMonthData = bookKingOfTheMonthDataList,
                    modifier = Modifier
                        .height(239.dp)
                        .fillMaxWidth(),
                )
            }
        }
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