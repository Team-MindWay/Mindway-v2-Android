package com.chobo.presentation.view.component.compostionView

import androidx.compose.runtime.MutableState
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.chobo.presentation.view.component.bottom_navigation_bar.MindWayNavBarItemType

const val CombinationViewRoute = "combination_view_route"

fun NavController.navigationToCombinationView() {
    this.navigate(CombinationViewRoute)
}

fun NavGraphBuilder.combinationScreen(
    currentDestination: MutableState<MindWayNavBarItemType>,
    navigateToDetailEvent: () -> Unit,
    navigateToGoalReading: () -> Unit,
    navigateToBookAddBook: () -> Unit,
    navigateToIntro: () -> Unit,
    navigateToMyBookEdit: () -> Unit,
) {
    composable(CombinationViewRoute) {
        MindWayCombinationView(
            currentDestination = currentDestination,
            navigateToDetailEvent = navigateToDetailEvent,
            navigateToGoalReading = navigateToGoalReading,
            navigateToBookAddBook = navigateToBookAddBook,
            navigateToIntro = navigateToIntro,
            navigateToMyBookEdit = navigateToMyBookEdit,
        )
    }
}