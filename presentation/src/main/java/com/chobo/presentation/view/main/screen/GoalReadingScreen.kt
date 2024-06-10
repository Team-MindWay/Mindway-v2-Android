package com.chobo.presentation.view.main.screen

import androidx.activity.ComponentActivity
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
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
import com.chobo.presentation.view.component.customToast.MindWayToast
import com.chobo.presentation.view.component.icon.ChevronLeftIcon
import com.chobo.presentation.view.component.icon.PlusIcon
import com.chobo.presentation.view.component.multipleEventsCutterManager.clickableSingle
import com.chobo.presentation.view.component.topBar.MindWayTopAppBar
import com.chobo.presentation.view.main.component.GoalReadingBottomSheet
import com.chobo.presentation.view.main.component.GoalReadingChart
import com.chobo.presentation.view.main.component.GoalReadingListOfBooksReadItem
import com.chobo.presentation.view.theme.MindWayAndroidTheme
import com.chobo.presentation.view.theme.color.MindWayColor
import com.chobo.presentation.viewModel.goal.GoalReadingViewModel
import com.chobo.presentation.viewModel.goal.uistate.GetBookListUiState
import com.chobo.presentation.viewModel.main.uistate.GetWeekendGoalUiState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
internal fun GoalReadingRoute(
    modifier: Modifier = Modifier,
    goalReadingViewModel: GoalReadingViewModel = hiltViewModel(LocalContext.current as ComponentActivity),
    navigateToBack: () -> Unit,
    navigateToHomeAddBook: () -> Unit,
    navigateToHomeViewDetail: (Long) -> Unit,
) {
    val getWeekendGoalUiState by goalReadingViewModel.getWeekendGoalUiState.collectAsStateWithLifecycle()
    val getBookListUiState by goalReadingViewModel.getBookListUiState.collectAsStateWithLifecycle()
    val goalBookReadSetting by goalReadingViewModel.goalBookReadSetting.collectAsStateWithLifecycle()
    val goalBookReadSettingIsEmpty by goalReadingViewModel.goalBookReadSettingIsEmpty.collectAsStateWithLifecycle()
    val isToastVisible by goalReadingViewModel.isToastVisible.collectAsStateWithLifecycle()
    val isSuccess by goalReadingViewModel.isSuccess.collectAsStateWithLifecycle()
    val coroutineScope = rememberCoroutineScope()
    val focusManager = LocalFocusManager.current

    GoalReadingScreen(
        modifier = modifier,
        getWeekendGoalUiState = getWeekendGoalUiState,
        goalBookReadSetting = goalBookReadSetting,
        goalBookReadSettingIsEmpty = goalBookReadSettingIsEmpty,
        getBookListUiState = getBookListUiState,
        isToastVisible = isToastVisible,
        isSuccess = isSuccess,
        coroutineScope = coroutineScope,
        focusManager = focusManager,
        goalBookReadSettingOnClick = goalReadingViewModel::goalBookReadSettingOnClick,
        updateGoalBookReadSetting = goalReadingViewModel::updateGoalBookReadSetting,
        navigateToBack = navigateToBack,
        navigateToHomeAddBook = navigateToHomeAddBook,
        navigateToHomeViewDetail = navigateToHomeViewDetail,
    )
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
internal fun GoalReadingScreen(
    modifier: Modifier = Modifier,
    getWeekendGoalUiState: GetWeekendGoalUiState,
    goalBookReadSetting: String,
    goalBookReadSettingIsEmpty: Boolean,
    getBookListUiState: GetBookListUiState,
    isToastVisible: Boolean,
    isSuccess: Boolean,
    coroutineScope: CoroutineScope,
    focusManager: FocusManager,
    goalBookReadSettingOnClick: () -> Unit,
    updateGoalBookReadSetting: (String) -> Unit,
    navigateToBack: () -> Unit,
    navigateToHomeAddBook: () -> Unit,
    navigateToHomeViewDetail: (Long) -> Unit,
) {
    val sheetState = rememberModalBottomSheetState(
        ModalBottomSheetValue.Hidden,
        skipHalfExpanded = true
    )

    MindWayBottomSheetDialog(
        sheetContent = {
            GoalReadingBottomSheet(
                isError = goalBookReadSettingIsEmpty,
                textState = goalBookReadSetting,
                onclick = goalBookReadSettingOnClick,
                updateTextValue = updateGoalBookReadSetting
            )
        },
        sheetState = sheetState
    ) {
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
                            if (getWeekendGoalUiState == GetWeekendGoalUiState.Empty) {
                                PlusIcon(
                                    modifier = Modifier.clickableSingle(onClick = { coroutineScope.launch { sheetState.show() } }),
                                    tint = MindWayColor.Black
                                )
                            } else {
                                PlusIcon(tint = MindWayColor.GRAY400)
                            }
                        }
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
                                when (getWeekendGoalUiState) {
                                    is GetWeekendGoalUiState.Empty -> {
                                        GoalReadingChart(
                                            isHasData = false,
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .height(180.dp),
                                        )
                                    }

                                    is GetWeekendGoalUiState.Fail -> {
                                        GoalReadingChart(
                                            isHasData = false,
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .height(180.dp),
                                        )
                                    }

                                    is GetWeekendGoalUiState.Loading -> {
                                        GoalReadingChart(
                                            isHasData = false,
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .height(180.dp),
                                        )
                                    }

                                    is GetWeekendGoalUiState.Success -> {
                                        GoalReadingChart(
                                            isHasData = true,
                                            getWeekendGoalModel = getWeekendGoalUiState.data,
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .height(180.dp),
                                        )
                                        Column(
                                            verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterVertically),
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
                                }
                            }
                            when (getBookListUiState) {
                                is GetBookListUiState.Empty -> Unit
                                is GetBookListUiState.Fail -> Unit
                                is GetBookListUiState.Loading -> Unit
                                is GetBookListUiState.Success -> {
                                    items(getBookListUiState.data) { item ->
                                        GoalReadingListOfBooksReadItem(
                                            data = item,
                                            onClick = navigateToHomeViewDetail,
                                            modifier = Modifier.fillMaxWidth()
                                        )
                                    }
                                }
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