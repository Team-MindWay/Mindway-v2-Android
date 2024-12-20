@file:OptIn(ExperimentalMaterialApi::class)

package com.chobo.presentation.view.main.screen

import androidx.activity.ComponentActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.chobo.presentation.R
import com.chobo.presentation.view.component.bottom_sheet.MindWayBottomSheetDialog
import com.chobo.presentation.view.component.icon.ChevronLeftIcon
import com.chobo.presentation.view.component.icon.PlusIcon
import com.chobo.presentation.view.component.modifier.multipleEventsCutterManager.clickableSingle
import com.chobo.presentation.view.component.shimmer.shimmerEffect
import com.chobo.presentation.view.component.topBar.MindWayTopAppBar
import com.chobo.presentation.view.main.component.GoalReadingBottomSheet
import com.chobo.presentation.view.main.component.GoalReadingChart
import com.chobo.presentation.view.main.component.GoalReadingListOfBooksReadItem
import com.chobo.presentation.view.theme.MindWayAndroidTheme
import com.chobo.presentation.view.theme.color.MindWayColor
import com.chobo.presentation.viewModel.goal.GoalReadingViewModel
import com.chobo.presentation.viewModel.goal.uistate.GetBookListUiState
import com.chobo.presentation.viewModel.main.uistate.GetWeekendGoalUiState
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.SwipeRefreshIndicator
import com.google.accompanist.swiperefresh.SwipeRefreshState
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
internal fun GoalReadingRoute(
    modifier: Modifier = Modifier,
    goalReadingViewModel: GoalReadingViewModel = hiltViewModel(LocalContext.current as ComponentActivity),
    navigateToHomeViewDetail: (Long) -> Unit,
    navigateToBack: () -> Unit,
    navigateToHomeAddBook: () -> Unit,
) {
    val getWeekendGoalUiState by goalReadingViewModel.getWeekendGoalUiState.collectAsStateWithLifecycle()
    val getBookListUiState by goalReadingViewModel.getBookListUiState.collectAsStateWithLifecycle()
    val goalBookReadSetting by goalReadingViewModel.goalBookReadSetting.collectAsStateWithLifecycle()
    val goalBookReadSettingIsEmpty by goalReadingViewModel.goalBookReadSettingIsEmpty.collectAsStateWithLifecycle()
    val (swipeRefreshLoading, setSwipeRefreshLoading) = remember { mutableStateOf(false) }
    val swipeRefreshState = rememberSwipeRefreshState(isRefreshing = swipeRefreshLoading)
    val sheetState = rememberModalBottomSheetState(
        ModalBottomSheetValue.Hidden,
        skipHalfExpanded = true
    )

    GoalReadingScreen(
        modifier = modifier,
        sheetState = sheetState,
        getWeekendGoalUiState = getWeekendGoalUiState,
        goalBookReadSetting = goalBookReadSetting,
        goalBookReadSettingIsEmpty = goalBookReadSettingIsEmpty,
        getBookListUiState = getBookListUiState,
        swipeRefreshState = swipeRefreshState,
        goalBookReadSettingOnClick = goalReadingViewModel::goalBookReadSettingOnClick,
        updateGoalBookReadSetting = goalReadingViewModel::updateGoalBookReadSetting,
        dataInit = {
            setSwipeRefreshLoading(true)
            goalReadingViewModel.apply {
                getBookList()
                getWeekendGoal()
            }
        },
        navigateToBack = navigateToBack,
        navigateToHomeAddBook = navigateToHomeAddBook,
        navigateToHomeViewDetail = navigateToHomeViewDetail,
    )


    LaunchedEffect(swipeRefreshLoading) {
        delay(1000)
        setSwipeRefreshLoading(false)
    }

    LaunchedEffect(Unit) {
        setSwipeRefreshLoading(true)
        goalReadingViewModel.apply {
            getBookList()
            getWeekendGoal()
        }
    }
}

@Composable
internal fun GoalReadingScreen(
    modifier: Modifier = Modifier,
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
    focusManager: FocusManager = LocalFocusManager.current,
    sheetState: ModalBottomSheetState,
    getWeekendGoalUiState: GetWeekendGoalUiState,
    goalBookReadSetting: String,
    goalBookReadSettingIsEmpty: Boolean,
    getBookListUiState: GetBookListUiState,
    swipeRefreshState: SwipeRefreshState,
    goalBookReadSettingOnClick: () -> Unit,
    updateGoalBookReadSetting: (String) -> Unit,
    dataInit: () -> Unit,
    navigateToHomeViewDetail: (Long) -> Unit,
    navigateToBack: () -> Unit,
    navigateToHomeAddBook: () -> Unit,
) {
    MindWayAndroidTheme { colors, _ ->
        MindWayBottomSheetDialog(
            sheetContent = {
                GoalReadingBottomSheet(
                    isError = goalBookReadSettingIsEmpty,
                    textState = goalBookReadSetting,
                    onclick = {
                        goalBookReadSettingOnClick()
                        coroutineScope.launch { sheetState.hide() }
                    },
                    updateTextValue = updateGoalBookReadSetting
                )
            },
            sheetState = sheetState
        ) {
            Column(
                modifier = modifier
                    .background(color = colors.WHITE)
                    .pointerInput(Unit) {
                        detectTapGestures {
                            focusManager.clearFocus()
                        }
                    }
                    .padding(horizontal = 24.dp)
            ) {
                MindWayTopAppBar(
                    startIcon = {
                        ChevronLeftIcon(
                            modifier = Modifier.clickableSingle(
                                onClick = navigateToBack
                            )
                        )
                    },
                    midText = stringResource(R.string.goal_reading),
                    endIcon = {
                        when (getWeekendGoalUiState) {
                            is GetWeekendGoalUiState.Empty,
                            is GetWeekendGoalUiState.Fail -> {
                                PlusIcon(
                                    modifier = Modifier.clickableSingle(onClick = { coroutineScope.launch { sheetState.show() } }),
                                    tint = MindWayColor.Black
                                )
                            }

                            else -> {
                                PlusIcon(tint = MindWayColor.GRAY400)
                            }
                        }
                    }
                )
                SwipeRefresh(
                    state = swipeRefreshState,
                    onRefresh = {
                        dataInit()
                    },
                    indicator = { state, refreshTrigger ->
                        SwipeRefreshIndicator(
                            state = state,
                            refreshTriggerDistance = refreshTrigger,
                            contentColor = colors.MAIN
                        )
                    }
                ) {
                    Box(modifier = Modifier.fillMaxSize()) {
                        LazyColumn(
                            verticalArrangement = Arrangement.spacedBy(20.dp, Alignment.Top),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier
                                .padding(top = 12.dp)
                                .fillMaxSize()
                        ) {
                            item {
                                when (getWeekendGoalUiState) {
                                    is GetWeekendGoalUiState.Success -> {
                                        GoalReadingChart(
                                            isHasData = true,
                                            getWeekendGoalModel = getWeekendGoalUiState.data,
                                            modifier = Modifier
                                                .fillMaxWidth(),
                                        )
                                    }

                                    is GetWeekendGoalUiState.Empty -> {
                                        GoalReadingChart(
                                            errorText = stringResource(R.string.goal_reading_error),
                                            isHasData = false,
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .height(180.dp),
                                        )
                                    }

                                    is GetWeekendGoalUiState.Loading -> {
                                        GoalReadingChart(
                                            errorText = "로딩중 ..",
                                            isHasData = false,
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .height(180.dp),
                                        )
                                    }

                                    is GetWeekendGoalUiState.Fail -> {
                                        GoalReadingChart(
                                            errorText = "통신이 원활하지 않습니다",
                                            isHasData = false,
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .height(180.dp),
                                        )
                                    }
                                }
                                Column(
                                    verticalArrangement = Arrangement.spacedBy(
                                        8.dp,
                                        Alignment.CenterVertically
                                    ),
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    modifier = modifier
                                        .shadow(
                                            elevation = 20.dp,
                                            spotColor = colors.CardShadow,
                                            ambientColor = colors.CardShadow
                                        )
                                        .background(
                                            color = colors.WHITE,
                                            shape = RoundedCornerShape(size = 8.dp)
                                        )
                                        .clickableSingle(onClick = navigateToHomeAddBook)
                                        .padding(16.dp)
                                ) {
                                    PlusIcon(modifier = Modifier.fillMaxSize())
                                }
                            }
                            when (getBookListUiState) {
                                is GetBookListUiState.Success -> {
                                    items(getBookListUiState.data.reversed()) { item ->
                                        GoalReadingListOfBooksReadItem(
                                            data = item,
                                            onClick = navigateToHomeViewDetail,
                                            modifier = Modifier.fillMaxWidth()
                                        )
                                    }
                                }

                                is GetBookListUiState.Loading -> {
                                    items(5) {
                                        Spacer(
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .height(110.dp)
                                                .background(
                                                    color = colors.WHITE,
                                                    shape = RoundedCornerShape(8.dp)
                                                )
                                                .shimmerEffect(shape = RoundedCornerShape(8.dp))
                                                .padding(vertical = 16.dp)
                                        )
                                    }
                                }

                                else -> Unit
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GoalReadingScreenPreview() {
    GoalReadingScreen(
        navigateToBack = { },
        navigateToHomeAddBook = { },
        navigateToHomeViewDetail = { },
        dataInit = {},
        getWeekendGoalUiState = GetWeekendGoalUiState.Loading,
        getBookListUiState = GetBookListUiState.Loading,
        goalBookReadSetting = "",
        goalBookReadSettingIsEmpty = false,
        goalBookReadSettingOnClick = {},
        swipeRefreshState = rememberSwipeRefreshState(isRefreshing = false),
        updateGoalBookReadSetting = { _ -> },
        sheetState = rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)
    )
}