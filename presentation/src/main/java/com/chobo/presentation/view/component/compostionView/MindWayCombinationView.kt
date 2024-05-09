package com.chobo.presentation.view.component.compostionView

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.chobo.presentation.view.book.screen.BookRoute
import com.chobo.presentation.view.component.bottom_navigation_bar.MindWayNavBar
import com.chobo.presentation.view.component.bottom_navigation_bar.MindWayNavBarItemType
import com.chobo.presentation.view.component.bottom_navigation_bar.MindWayNavBarItemType.BOOKS
import com.chobo.presentation.view.component.bottom_navigation_bar.MindWayNavBarItemType.EVENT
import com.chobo.presentation.view.component.bottom_navigation_bar.MindWayNavBarItemType.HOME
import com.chobo.presentation.view.component.bottom_navigation_bar.MindWayNavBarItemType.MY
import com.chobo.presentation.view.component.bottom_sheet.MindWayBottomSheetDialog
import com.chobo.presentation.view.event.screen.EventScreen
import com.chobo.presentation.view.main.screen.HomeScreen
import com.chobo.presentation.view.my.component.MyBottomSheet
import com.chobo.presentation.view.my.screen.MyScreen
import com.chobo.presentation.viewModel.event.uistate.GetDetailEventUiState
import com.chobo.presentation.viewModel.event.uistate.GetEventDateListUiState
import com.chobo.presentation.viewModel.event.uistate.GetEventListUiState
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MindWayCombinationView(
    topDestination: MutableState<MindWayNavBarItemType>,
    navigateToDetailEvent: () -> Unit,
    navigateToGoalReading: () -> Unit,
    navigateToBookAddBook: () -> Unit,
    navigateToIntro: () -> Unit,
    navigateToMyBookEdit: () -> Unit,
) {
    val coroutineScope = rememberCoroutineScope()
    MindWayBottomSheetDialog(
        sheetContent = {
            MyBottomSheet(
                navigateToIntro = navigateToIntro,
                logoutOnClick = { }
            )
        }
    ) { sheetState ->
        Scaffold(bottomBar = {
            MindWayNavBar(
                currentDestination = topDestination,
                navigateToHome = { topDestination.value = HOME },
                navigateToEvent = { topDestination.value = EVENT },
                navigateToBooks = { topDestination.value = BOOKS },
                navigateToMy = { topDestination.value = MY }
            )
        }
        ) { paddingValues ->
            Box(modifier = Modifier.padding(paddingValues)) {
                when (topDestination.value) {
                    HOME -> HomeScreen(
                        navigateToGoalReading = navigateToGoalReading,
                        navigateToDetailEvent = navigateToDetailEvent,
                    )

                    EVENT -> EventScreen(
                        navigateToDetailEvent = navigateToDetailEvent,
                        getEventListUiState = GetEventListUiState.Loading,
                        getDetailEventUiState = GetDetailEventUiState.Loading,
                        getEventDateListUiState = GetEventDateListUiState.Loading,
                        mainCallBack = { }
                    )

                    BOOKS -> BookRoute(navigateToBookAddBook = navigateToBookAddBook)

                    MY -> MyScreen(
                        navigateToMyBookEdit = navigateToMyBookEdit,
                        onClick = {
                            coroutineScope.launch {
                                sheetState.show()
                            }
                        }
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun MindWayCombinationViewPreview() {
    val topDestination = remember {
        mutableStateOf(HOME)
    }
    MindWayCombinationView(
        topDestination = topDestination,
        navigateToDetailEvent = { },
        navigateToGoalReading = { },
        navigateToBookAddBook = { },
        navigateToIntro = { },
        navigateToMyBookEdit = { }
    )
}