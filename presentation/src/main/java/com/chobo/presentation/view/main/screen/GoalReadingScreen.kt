package com.chobo.presentation.view.main.screen

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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.chobo.presentation.view.component.bottom_sheet.MindWayBottomSheetDialog
import com.chobo.presentation.view.component.customToast.MindWayToast
import com.chobo.presentation.view.main.component.GoalReadingBottomSheet
import com.chobo.presentation.view.main.component.GoalReadingChart
import com.chobo.presentation.view.main.component.GoalReadingListOfBooksReadItem
import com.chobo.presentation.view.main.component.GoalReadingPlusCard
import com.chobo.presentation.view.main.component.GoalReadingTopAppBar
import com.chobo.presentation.view.theme.MindWayAndroidTheme
import com.chobo.presentation.viewModel.GoalReadingViewModel
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
    val goalReadingGraphDataList by goalReadingViewModel.goalReadingGraphDataList.collectAsState()
    val goalReadingListOfBooksReadItemDataList by goalReadingViewModel.goalReadingListOfBooksReadItemDataList.collectAsState()
    val coroutineScope = rememberCoroutineScope()

    MindWayBottomSheetDialog(
        sheetContent = {
            GoalReadingBottomSheet(
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
                                isHasData = true,
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
                    MindWayToast(
                        text = "임시 토스트 메시지",
                        isSuccess = true,
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.BottomCenter)
                            .offset(y = 64.dp),
                    )
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