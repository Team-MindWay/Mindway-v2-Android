package com.chobo.presentation.view.component.combinationView

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.chobo.presentation.view.book.screen.BookRoute
import com.chobo.presentation.view.component.bottom_navigation_bar.MindWayNavBar
import com.chobo.presentation.view.component.bottom_navigation_bar.MindWayNavBarItemType
import com.chobo.presentation.view.component.bottom_navigation_bar.MindWayNavBarItemType.BOOKS
import com.chobo.presentation.view.component.bottom_navigation_bar.MindWayNavBarItemType.EVENT
import com.chobo.presentation.view.component.bottom_navigation_bar.MindWayNavBarItemType.HOME
import com.chobo.presentation.view.component.bottom_navigation_bar.MindWayNavBarItemType.MY
import com.chobo.presentation.view.event.screen.EventScreenRoute
import com.chobo.presentation.view.main.screen.HomeRoute
import com.chobo.presentation.view.my.screen.MyRoute

@Composable
fun MindWayCombinationView(
    topDestination: MutableState<MindWayNavBarItemType>,
    navigateToDetailEvent: () -> Unit,
    navigateToGoalReading: () -> Unit,
    navigateToBookAddBook: () -> Unit,
    navigateToIntro: () -> Unit,
    navigateToMyBookEdit: () -> Unit,
    navigateToLogin: () -> Unit,
) {
    Scaffold(
        bottomBar = {
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

                MY -> MyRoute(
                    navigateToIntro = navigateToIntro,
                    navigateToLogin = navigateToLogin,
                    navigateToMyBookEdit = navigateToMyBookEdit,
                )
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
        navigateToMyBookEdit = { },
        navigateToLogin = { }
    )
}