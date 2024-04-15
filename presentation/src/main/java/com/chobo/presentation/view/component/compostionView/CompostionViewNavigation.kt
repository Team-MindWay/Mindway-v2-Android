package com.chobo.presentation.view.component.compostionView

import androidx.compose.runtime.MutableState
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.chobo.presentation.view.component.bottom_navigation_bar.MindWayNavBarItemType

const val CompostionViewRoute = "copmostion_view_route"

fun NavController.navigationToCompostionView() {
    this.navigate(CompostionViewRoute)
}

fun NavGraphBuilder.CompostionView(
    navigateToDetailEvent: () -> Unit,
    navigateToGoalReading: () -> Unit,
    topDestination: MutableState<MindWayNavBarItemType>,
    navigateToBookAddBook: () -> Unit,
) {
    composable(CompostionViewRoute) {
        MindWayCombinationView(
            topDestination = topDestination,
            navigateToDetailEvent = navigateToDetailEvent,
            navigateToGoalReading = navigateToGoalReading,
            navigateToBookAddBook = navigateToBookAddBook,
        )
    }
}