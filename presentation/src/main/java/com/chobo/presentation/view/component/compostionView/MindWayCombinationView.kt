package com.chobo.presentation.view.component.compostionView

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.chobo.presentation.view.book.screen.BookScreen
import com.chobo.presentation.view.component.bottom_navigation_bar.MindWayNavBar
import com.chobo.presentation.view.component.bottom_navigation_bar.MindWayNavBarItemType
import com.chobo.presentation.view.component.bottom_navigation_bar.MindWayNavBarItemType.BOOKS
import com.chobo.presentation.view.component.bottom_navigation_bar.MindWayNavBarItemType.EVENT
import com.chobo.presentation.view.component.bottom_navigation_bar.MindWayNavBarItemType.HOME
import com.chobo.presentation.view.component.bottom_navigation_bar.MindWayNavBarItemType.MY
import com.chobo.presentation.view.component.bottom_sheet.MindWayBottomSheetDialog
import com.chobo.presentation.view.component.icon.LogoIcon
import com.chobo.presentation.view.component.topBar.MindWayTopAppBar
import com.chobo.presentation.view.event.screen.EventScreen
import com.chobo.presentation.view.main.screen.HomeScreen
import com.chobo.presentation.view.my.component.MyBottomSheet
import com.chobo.presentation.view.my.screen.MyScreen
import com.chobo.presentation.view.theme.MindWayAndroidTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MindWayCombinationView(
    currentDestination: MutableState<MindWayNavBarItemType>,
    navigateToDetailEvent: () -> Unit,
    navigateToGoalReading: () -> Unit,
    navigateToBookAddBook: () -> Unit,
    navigateToIntro: () -> Unit,
    navigateToMyBookEdit: () -> Unit,
) {
    val coroutineScope = rememberCoroutineScope()
    MindWayAndroidTheme { colors, _ ->

        MindWayBottomSheetDialog(
            sheetContent = {
                MyBottomSheet(
                    navigateToIntro = navigateToIntro,
                    logoutOnClick = { }
                )
            }
        ) { sheetState ->
            Scaffold(
                topBar = {
                    if (currentDestination.value == HOME) {
                        MindWayTopAppBar(
                            modifier = Modifier.background(color = colors.WHITE),
                            startIcon = { LogoIcon() },
                        )
                    }
                },
                bottomBar = {
                    MindWayNavBar(
                        currentDestination = currentDestination,
                        navigateToHome = { currentDestination.value = HOME },
                        navigateToEvent = { currentDestination.value = EVENT },
                        navigateToBooks = { currentDestination.value = BOOKS },
                        navigateToMy = { currentDestination.value = MY }
                    )
                }
            ) {
                Column(modifier = Modifier.padding(it)) {
                    when (currentDestination.value) {
                        HOME -> HomeScreen(
                            navigateToGoalReading = navigateToGoalReading,
                            navigateToDetailEvent = navigateToDetailEvent,
                        )
                        EVENT -> EventScreen(navigateToDetailEvent = navigateToDetailEvent)
                        BOOKS -> BookScreen(navigateToBookAddBook = navigateToBookAddBook)
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
}

@Preview
@Composable
fun MindWayCombinationViewPreview() {
    val topDestination = remember {
        mutableStateOf(HOME)
    }
    MindWayCombinationView(
        currentDestination = topDestination,
        navigateToDetailEvent = { },
        navigateToGoalReading = { },
        navigateToBookAddBook = { },
        navigateToIntro = { },
        navigateToMyBookEdit = { }
    )
}