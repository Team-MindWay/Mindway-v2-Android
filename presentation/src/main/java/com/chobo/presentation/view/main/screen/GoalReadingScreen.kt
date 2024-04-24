package com.chobo.presentation.view.main.screen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.chobo.presentation.R
import com.chobo.presentation.view.component.bottom_sheet.MindWayBottomSheetDialog
import com.chobo.presentation.view.component.customToast.MindWayToast
import com.chobo.presentation.view.main.component.GoalReadingBottomSheet
import com.chobo.presentation.view.main.component.GoalReadingChart
import com.chobo.presentation.view.main.component.GoalReadingListOfBooksReadItem
import com.chobo.presentation.view.main.component.GoalReadingPlusCard
import com.chobo.presentation.view.main.component.GoalReadingTopAppBar
import com.chobo.presentation.view.theme.MindWayAndroidTheme
import com.chobo.presentation.viewModel.GoalReadingViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun GoalReadingScreen(
    modifier: Modifier = Modifier,
    goalReadingViewModel: GoalReadingViewModel = viewModel(),
    navigateToBack: () -> Unit,
    navigateToHomeAddBook: () -> Unit,
    navigateToHomeViewDetail: () -> Unit,
) {
    val goalBookRead by goalReadingViewModel.goalBookRead.collectAsState()
    val goalBookReadSetting by goalReadingViewModel.goalBookReadSetting.collectAsState()
    val goalBookReadSettingIsEmpty by goalReadingViewModel.goalBookReadSettingIsEmpty.collectAsState()
    val goalReadingGraphDataList by goalReadingViewModel.goalReadingGraphDataList.collectAsState()
    val goalReadingListOfBooksReadItemDataList by goalReadingViewModel.goalReadingListOfBooksReadItemDataList.collectAsState()
    val isToastVisible by goalReadingViewModel.isToastVisible.collectAsState()
    val coroutineScope = rememberCoroutineScope()


    LaunchedEffect(isToastVisible) {
        delay(2000)
        goalReadingViewModel.toggleIsToastVisible()
    }

    MindWayBottomSheetDialog(
        sheetContent = {
            GoalReadingBottomSheet(
                isError = goalBookReadSettingIsEmpty,
                textState = goalBookReadSetting,
                onclick = goalReadingViewModel::goalBookReadSettingOnClick,
                updateTextValue = goalReadingViewModel::updateGoalBookReadSetting
            )
        }
    ) { sheetState ->
        MindWayAndroidTheme { colors, _ ->
            Column(modifier = modifier.background(color = colors.WHITE)) {
                Spacer(modifier = Modifier.height(20.dp))
                GoalReadingTopAppBar(
                    startIconOnClick = navigateToBack,
                    endIconOnClick = {

                        coroutineScope.launch { sheetState.show() }
                    },
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
                        modifier = Modifier
                            .align(Alignment.BottomCenter)
                            .offset(y = (-50).dp),
                        enter = slideInVertically(
                            initialOffsetY = { it },
                            animationSpec = tween(durationMillis = 500)
                        ),
                        exit = slideOutVertically(
                            targetOffsetY = { it },
                            animationSpec = tween(durationMillis = 500)
                        )
                    ) {
                        Column(modifier = Modifier
                            .padding(horizontal = 24.dp)
                            .fillMaxWidth()) {
                            MindWayToast(
                                isSuccess = true,
                                text = toastText,
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
        GoalReadingScreen(
            navigateToBack = { },
            navigateToHomeAddBook = { },
            navigateToHomeViewDetail = { },
        )
    }
}