package com.chobo.presentation.view.component.compostionView

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import com.chobo.presentation.view.book.screen.BookScreen
import com.chobo.presentation.view.component.bottom_navigation_bar.MindWayNavBarItemType
import com.chobo.presentation.view.component.bottom_navigation_bar.MindWayNavBarItemType.*
import com.chobo.presentation.view.component.icon.LogoIcon
import com.chobo.presentation.view.component.scaffold.MindWayScaffold
import com.chobo.presentation.view.event.screen.EventScreen
import com.chobo.presentation.view.main.screen.HomeScreen
import com.chobo.presentation.view.my.screen.MyScreen

@Composable
fun MindWayCombinationView(
    topDestination: MutableState<MindWayNavBarItemType>,
    navigateToDetailEvent: () -> Unit,
    navigateToGoalReading: () -> Unit,
) {
    MindWayScaffold(
        currentDestination = topDestination,
        isTopAppBar = topDestination.value == HOME,
        startIcon = {
            if (topDestination.value != HOME) {
                null
            } else {
                LogoIcon()
            }
        }
    ) {
        when (topDestination.value) {
            HOME -> HomeScreen(
                navigateToGoalReading = { navigateToGoalReading() },
                navigateToDetailEvent = { navigateToDetailEvent() },
            )
            EVENT -> EventScreen(navigateToDetailEvent = { navigateToDetailEvent() })
            BOOKS -> BookScreen()
            MY -> MyScreen()
        }
    }
}