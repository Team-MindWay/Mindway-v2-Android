package com.chobo.presentation.view.component.compostionView

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.chobo.presentation.view.book.screen.BookScreen
import com.chobo.presentation.view.component.bottom_navigation_bar.MindWayNavBarItemType.*
import com.chobo.presentation.view.component.icon.LogoIcon
import com.chobo.presentation.view.component.scaffold.MindWayScaffold
import com.chobo.presentation.view.event.screen.EventScreen
import com.chobo.presentation.view.main.screen.HomeScreen
import com.chobo.presentation.view.my.screen.MyScreen

@Composable
fun MindWayCombinationView() {
    val topDestination = remember {
        mutableStateOf(HOME)
    }
    val isTopAppBar by remember {
        mutableStateOf(
            topDestination.value == HOME
        )
    }
    MindWayScaffold(
        currentDestination = topDestination,
        isTopAppBar = isTopAppBar,
        startIcon = { if (topDestination.value != HOME) {
        } else {
            LogoIcon()
        } }
    ) {
        when (topDestination.value) {
            HOME -> HomeScreen(navigateToGoalReading = { /*TODO*/ }) {}
            EVENT -> EventScreen(navigateToDetailEvent = { /*TODO*/ })
            BOOKS -> BookScreen()
            MY -> MyScreen()
        }
    }
}