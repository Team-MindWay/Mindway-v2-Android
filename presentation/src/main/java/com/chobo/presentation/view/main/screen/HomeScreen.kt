package com.chobo.presentation.view.main.screen

import androidx.activity.ComponentActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.chobo.presentation.view.component.icon.LogoIcon
import com.chobo.presentation.view.component.topBar.MindWayTopAppBar
import com.chobo.presentation.view.main.component.HomeErrorNoticeCard
import com.chobo.presentation.view.main.component.HomeGoalReadingChart
import com.chobo.presentation.view.main.component.HomeNoticeCard
import com.chobo.presentation.view.main.component.HomeReadersOfTheMonthChart
import com.chobo.presentation.view.theme.MindWayAndroidTheme
import com.chobo.presentation.viewModel.main.HomeViewModel
import com.chobo.presentation.viewModel.main.uistate.GetRankUiState
import com.chobo.presentation.viewModel.main.uistate.GetWeekendGoalUiState
import com.chobo.presentation.viewModel.main.uistate.NoticeGetUiState

@Composable
internal fun HomeRoute(
    modifier: Modifier = Modifier,
    homeViewModel: HomeViewModel = hiltViewModel(LocalContext.current as ComponentActivity),
    navigateToGoalReading: () -> Unit,
) {
    val getWeekendGoalUIState by homeViewModel.getWeekendGoalUIState.collectAsStateWithLifecycle()
    val noticeGetUiState by homeViewModel.noticeGetUiState.collectAsStateWithLifecycle()
    val getRankUIState by homeViewModel.getRankUIState.collectAsStateWithLifecycle()

    HomeScreen(
        modifier = modifier,
        getWeekendGoalUIState = getWeekendGoalUIState,
        noticeGetUiState = noticeGetUiState,
        getRankUIState = getRankUIState,
        navigateToGoalReading = navigateToGoalReading,
    )

    LaunchedEffect(Unit) {
        homeViewModel.apply {
            getNotice()
            getRank()
            getWeekendGoal()
        }
    }
}

@Composable
internal fun HomeScreen(
    modifier: Modifier = Modifier,
    getWeekendGoalUIState: GetWeekendGoalUiState,
    noticeGetUiState: NoticeGetUiState,
    getRankUIState: GetRankUiState,
    navigateToGoalReading: () -> Unit,
) {
    MindWayAndroidTheme { colors, _ ->
        Column(
            verticalArrangement = Arrangement.spacedBy(20.dp, Alignment.Top),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .background(color = colors.WHITE)
                .fillMaxSize()
                .padding(horizontal = 24.dp)
        ) {
            MindWayTopAppBar(startIcon = { LogoIcon() })
            when (noticeGetUiState) {
                is NoticeGetUiState.Success -> {
                    HomeNoticeCard(
                        noticeAllModel = noticeGetUiState.data,
                        modifier = Modifier
                            .height(100.dp)
                            .fillMaxWidth(),
                    )
                }

                is NoticeGetUiState.Loading -> {
                    HomeErrorNoticeCard(
                        text = "데이터를 불러오는 중..",
                        modifier = Modifier
                            .height(100.dp)
                            .fillMaxWidth(),
                    )
                }

                is NoticeGetUiState.Fail -> {
                    HomeErrorNoticeCard(
                        text = "공지가 없습니다.",
                        modifier = Modifier
                            .height(100.dp)
                            .fillMaxWidth(),
                    )
                }
            }
            when (getWeekendGoalUIState) {
                is GetWeekendGoalUiState.Success -> {
                    HomeGoalReadingChart(
                        getWeekendGoalModel = getWeekendGoalUIState.data,
                        isHasData = true,
                        onClick = navigateToGoalReading,
                        modifier = Modifier
                            .fillMaxWidth(),
                    )
                }

                is GetWeekendGoalUiState.Loading -> {
                    HomeGoalReadingChart(
                        errorText = "로딩중 ..",
                        isHasData = false,
                        onClick = navigateToGoalReading,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(211.dp),
                    )
                }

                is GetWeekendGoalUiState.Empty -> {
                    HomeGoalReadingChart(
                        errorText = "목표 도서량을 입력해주세요",
                        isHasData = false,
                        onClick = navigateToGoalReading,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(211.dp),
                    )
                }

                is GetWeekendGoalUiState.Fail -> {
                    HomeGoalReadingChart(
                        errorText = "통신 상태가 원활하지 않습니다",
                        isHasData = false,
                        onClick = navigateToGoalReading,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(211.dp),
                    )
                }
            }
            when (getRankUIState) {
                is GetRankUiState.Success -> {
                    HomeReadersOfTheMonthChart(
                        isHasData = true,
                        bookKingOfTheMonthData = getRankUIState.data,
                        modifier = Modifier
                            .fillMaxWidth(),
                    )
                }

                is GetRankUiState.Loading -> {
                    HomeReadersOfTheMonthChart(
                        errorText = "로딩중 ..",
                        isHasData = false,
                        modifier = Modifier
                            .height(239.dp)
                            .fillMaxWidth(),
                    )
                }

                is GetRankUiState.Empty -> {
                    HomeReadersOfTheMonthChart(
                        errorText = "아직 이달의 독서왕이 없습니다",
                        isHasData = false,
                        modifier = Modifier
                            .height(239.dp)
                            .fillMaxWidth(),
                    )
                }

                is GetRankUiState.Fail -> {
                    HomeReadersOfTheMonthChart(
                        errorText = "통신 상태가 원활하지 않습니다",
                        isHasData = false,
                        modifier = Modifier
                            .height(239.dp)
                            .fillMaxWidth(),
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(
        getWeekendGoalUIState = GetWeekendGoalUiState.Loading,
        noticeGetUiState = NoticeGetUiState.Loading,
        getRankUIState = GetRankUiState.Loading
    ) {}
}