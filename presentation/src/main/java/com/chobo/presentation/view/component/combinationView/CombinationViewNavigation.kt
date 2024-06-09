package com.chobo.presentation.view.component.combinationView

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.chobo.presentation.view.component.bottom_navigation_bar.MindWayNavBarItemType

const val CombinationViewRoute = "combination_view_route"

fun NavController.navigationToCombinationView() {
    this.navigate(CombinationViewRoute)
}

fun NavGraphBuilder.combinationView(
    currentDestination: MindWayNavBarItemType,
    setCurrentDestination: (MindWayNavBarItemType) -> Unit,
    navigateToDetailEvent: (Long) -> Unit,
    navigateToGoalReading: () -> Unit,
    navigateToBookAddBook: () -> Unit,
    navigateToIntro: () -> Unit,
    navigateToMyBookEdit: (Long) -> Unit,
    navigateToLogin: () -> Unit,
) {
    composable(CombinationViewRoute) {
        MindWayCombinationView(
            currentDestination = currentDestination,
            setCurrentDestination = setCurrentDestination,
            navigateToDetailEvent = navigateToDetailEvent,
            navigateToGoalReading = navigateToGoalReading,
            navigateToBookAddBook = navigateToBookAddBook,
            navigateToIntro = navigateToIntro,
            navigateToMyBookEdit = navigateToMyBookEdit,
            navigateToLogin = navigateToLogin,
        )
    }
}