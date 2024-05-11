package com.chobo.presentation.view.main.screen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.chobo.presentation.R
import com.chobo.presentation.view.component.bottom_sheet.MindWayBottomSheetDialog
import com.chobo.presentation.view.component.customToast.MindWayToast
import com.chobo.presentation.view.main.component.GoalReadingBottomSheet
import com.chobo.presentation.view.main.component.GoalReadingChart
import com.chobo.presentation.view.main.component.GoalReadingGraphData
import com.chobo.presentation.view.main.component.GoalReadingListOfBooksReadItem
import com.chobo.presentation.view.main.component.GoalReadingListOfBooksReadItemData
import com.chobo.presentation.view.main.component.GoalReadingPlusCard
import com.chobo.presentation.view.main.component.GoalReadingTopAppBar
import com.chobo.presentation.view.theme.MindWayAndroidTheme
import com.chobo.presentation.viewModel.goal.GoalReadingViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
internal fun GoalReadingRoute(
    modifier: Modifier = Modifier,
    goalReadingViewModel: GoalReadingViewModel = viewModel(),
    navigateToBack: () -> Unit,
    navigateToHomeAddBook: () -> Unit,
    navigateToHomeViewDetail: () -> Unit,
) {
    val goalBookRead by goalReadingViewModel.goalBookRead.collectAsStateWithLifecycle()
    val goalBookReadSetting by goalReadingViewModel.goalBookReadSetting.collectAsStateWithLifecycle()
    val goalBookReadSettingIsEmpty by goalReadingViewModel.goalBookReadSettingIsEmpty.collectAsStateWithLifecycle()
    val goalReadingGraphDataList by goalReadingViewModel.goalReadingGraphDataList.collectAsStateWithLifecycle()
    val goalReadingListOfBooksReadItemDataList by goalReadingViewModel.goalReadingListOfBooksReadItemDataList.collectAsStateWithLifecycle()
    val isToastVisible by goalReadingViewModel.isToastVisible.collectAsStateWithLifecycle()
    val isSuccess by goalReadingViewModel.isSuccess.collectAsStateWithLifecycle()
    val coroutineScope = rememberCoroutineScope()
    val focusManager = LocalFocusManager.current

    GoalReadingScreen(
        modifier = modifier,
        goalBookRead = goalBookRead,
        goalBookReadSetting = goalBookReadSetting,
        goalBookReadSettingIsEmpty = goalBookReadSettingIsEmpty,
        goalReadingGraphDataList = goalReadingGraphDataList,
        goalReadingListOfBooksReadItemDataList = goalReadingListOfBooksReadItemDataList,
        isToastVisible = isToastVisible,
        isSuccess = isSuccess,
        coroutineScope = coroutineScope,
        focusManager = focusManager,
        navigateToBack = navigateToBack,
        navigateToHomeAddBook = navigateToHomeAddBook,
        navigateToHomeViewDetail = navigateToHomeViewDetail,
        goalBookReadSettingOnClick = goalReadingViewModel::goalBookReadSettingOnClick,
        updateGoalBookReadSetting = goalReadingViewModel::updateGoalBookReadSetting
    )
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
internal fun GoalReadingScreen(
    modifier: Modifier = Modifier,
    goalBookRead: Int,
    goalBookReadSetting: String,
    goalBookReadSettingIsEmpty: Boolean,
    goalReadingGraphDataList: List<GoalReadingGraphData>,
    goalReadingListOfBooksReadItemDataList: List<GoalReadingListOfBooksReadItemData>,
    isToastVisible: Boolean,
    isSuccess: Boolean,
    coroutineScope: CoroutineScope,
    focusManager: FocusManager,
    navigateToBack: () -> Unit,
    navigateToHomeAddBook: () -> Unit,
    navigateToHomeViewDetail: () -> Unit,
    goalBookReadSettingOnClick: () -> Unit,
    updateGoalBookReadSetting: (String) -> Unit,
) {

    MindWayBottomSheetDialog(
        sheetContent = {
            GoalReadingBottomSheet(
                isError = goalBookReadSettingIsEmpty,
                textState = goalBookReadSetting,
                onclick = goalBookReadSettingOnClick,
                updateTextValue = updateGoalBookReadSetting
            )
        }
    ) { sheetState ->
        MindWayAndroidTheme { colors, _ ->
            CompositionLocalProvider(values = arrayOf(LocalFocusManager provides focusManager)) {
                Column(
                    modifier = modifier
                        .background(color = colors.WHITE)
                        .pointerInput(Unit) {
                            detectTapGestures {
                                focusManager.clearFocus()
                            }
                        }
                ) {
                    GoalReadingTopAppBar(
                        startIconOnClick = navigateToBack,
                        endIconOnClick = { coroutineScope.launch { sheetState.show() } },
                        isData = goalBookRead == 0
                    )
                    Box(modifier = Modifier.fillMaxSize()) {
                        LazyColumn(
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
                            item {
                                GoalReadingChart(
                                    goalBookRead = goalBookRead,
                                    goalReadingGraphData = goalReadingGraphDataList,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(180.dp),
                                )
                            }
                            item {
                                GoalReadingPlusCard(
                                    onClick = navigateToHomeAddBook,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(60.dp)
                                )
                            }
                            items(goalReadingListOfBooksReadItemDataList) { item ->
                                GoalReadingListOfBooksReadItem(
                                    data = item,
                                    onClick = navigateToHomeViewDetail,
                                    modifier = Modifier.fillMaxWidth()
                                )
                            }
                        }
                        this@Column.AnimatedVisibility(
                            visible = isToastVisible,
                            enter = slideInVertically(
                                initialOffsetY = { it + 110 },
                                animationSpec = tween(durationMillis = 500)
                            ),
                            exit = slideOutVertically(
                                targetOffsetY = { it + 110 },
                                animationSpec = tween(durationMillis = 500)
                            ),
                            modifier = Modifier
                                .align(Alignment.BottomCenter)
                                .offset(y = (-40).dp)
                                .padding(horizontal = 24.dp),
                        ) {
                            MindWayToast(
                                isSuccess = isSuccess,
                                text = if (isSuccess) stringResource(R.string.goal_reading_fail_toast)
                                else stringResource(R.string.goal_reading_success_toast),
                                modifier = Modifier.fillMaxWidth()
                            )
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
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        GoalReadingRoute(
            navigateToBack = { },
            navigateToHomeAddBook = { },
            navigateToHomeViewDetail = { },
        )
    }
}