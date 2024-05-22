package com.chobo.presentation.view.main.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.chobo.presentation.view.component.icon.LogoIcon
import com.chobo.presentation.view.component.topBar.MindWayTopAppBar
import com.chobo.presentation.view.main.component.HomeGoalReadingChart
import com.chobo.presentation.view.main.component.HomeNoticeCard
import com.chobo.presentation.view.main.component.HomeReadersOfTheMonthChart
import com.chobo.presentation.view.theme.MindWayAndroidTheme
import com.chobo.presentation.viewModel.main.HomeViewModel
import com.chobo.presentation.viewModel.main.uistate.GetGoalUIState
import com.chobo.presentation.viewModel.main.uistate.GetRankUIState
import com.chobo.presentation.viewModel.main.uistate.NoticeGetUiState

@Composable
internal fun HomeRoute(
    modifier: Modifier = Modifier,
    homeViewModel: HomeViewModel = hiltViewModel(),
    navigateToGoalReading: () -> Unit,
    navigateToDetailEvent: () -> Unit,
) {
    val getGoalUIState by homeViewModel.getGoalUIState.collectAsStateWithLifecycle()
    val noticeGetUiState by homeViewModel.noticeGetUiState.collectAsStateWithLifecycle()
    val getRankUIState by homeViewModel.getRankUIState.collectAsStateWithLifecycle()

    HomeScreen(
        modifier = modifier,
        getGoalUIState = getGoalUIState,
        noticeGetUiState = noticeGetUiState,
        getRankUIState = getRankUIState,
        navigateToGoalReading = navigateToGoalReading,
        navigateToDetailEvent = navigateToDetailEvent,
    )
}

@Composable
internal fun HomeScreen(
    modifier: Modifier = Modifier,
    getGoalUIState: GetGoalUIState,
    noticeGetUiState: NoticeGetUiState,
    getRankUIState: GetRankUIState,
    navigateToGoalReading: () -> Unit,
    navigateToDetailEvent: () -> Unit,
) {
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
                when (noticeGetUiState) {
                    is NoticeGetUiState.Fail -> {}
                    is NoticeGetUiState.Loading -> {}
                    is NoticeGetUiState.Success -> {
                        HomeNoticeCard(
                            noticeAllModel = noticeGetUiState.data,
                            onClick = navigateToDetailEvent,
                            modifier = Modifier
                                .height(100.dp)
                                .fillMaxWidth(),
                        )
                    }
                }
                when (getGoalUIState) {
                    is GetGoalUIState.Empty -> TODO()
                    is GetGoalUIState.Fail -> TODO()
                    is GetGoalUIState.Loading -> TODO()
                    is GetGoalUIState.Success -> {
                        HomeGoalReadingChart(
                            goalWeekendResponse = getGoalUIState.data,
                            isHasData = true,
                            onClick = navigateToGoalReading,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(211.dp),
                        )
                    }
                }
                when (getRankUIState) {
                    is GetRankUIState.Empty -> {
                        HomeReadersOfTheMonthChart(
                            isHasData = false,
                            modifier = Modifier
                                .height(239.dp)
                                .fillMaxWidth(),
                        )
                    }

                    is GetRankUIState.Fail -> {
                        HomeReadersOfTheMonthChart(
                            isHasData = false,
                            modifier = Modifier
                                .height(239.dp)
                                .fillMaxWidth(),
                        )
                    }

                    is GetRankUIState.Loading -> {
                        HomeReadersOfTheMonthChart(
                            isHasData = false,
                            modifier = Modifier
                                .height(239.dp)
                                .fillMaxWidth(),
                        )
                    }

                    is GetRankUIState.Success -> {
                        HomeReadersOfTheMonthChart(
                            isHasData = true,
                            bookKingOfTheMonthData = getRankUIState.data,
                            modifier = Modifier
                                .height(239.dp)
                                .fillMaxWidth(),
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeRoute(
        navigateToGoalReading = { },
        navigateToDetailEvent = { }
    )
}