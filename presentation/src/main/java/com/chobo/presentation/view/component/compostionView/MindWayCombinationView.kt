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
import com.chobo.presentation.view.event.screen.EventScreenRoute
import com.chobo.presentation.view.main.screen.HomeRoute
import com.chobo.presentation.view.my.component.MyBottomSheet
import com.chobo.presentation.view.my.screen.MyScreen
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MindWayCombinationView(
    topDestination: MutableState<MindWayNavBarItemType>,
    coroutineScope : CoroutineScope = rememberCoroutineScope(),
    navigateToDetailEvent: () -> Unit,
    navigateToGoalReading: () -> Unit,
    navigateToBookAddBook: () -> Unit,
    navigateToIntro: () -> Unit,
    navigateToMyBookEdit: () -> Unit,
) {
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
                    HOME -> HomeRoute(
                        navigateToGoalReading = navigateToGoalReading,
                        navigateToDetailEvent = navigateToDetailEvent,
                    )

                    EVENT -> EventScreenRoute(navigateToDetailEvent = navigateToDetailEvent)

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