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

fun NavGraphBuilder.combinationView(
    navigateToDetailEvent: () -> Unit,
    navigateToGoalReading: () -> Unit,
    topDestination: MutableState<MindWayNavBarItemType>,
    navigateToBookAddBook: () -> Unit,
    navigateToIntro: () -> Unit,
    navigateToMyBookEdit: () -> Unit,
) {
    composable(CombinationViewRoute) {
        MindWayCombinationView(
            topDestination = topDestination,
            navigateToDetailEvent = navigateToDetailEvent,
            navigateToGoalReading = navigateToGoalReading,
            navigateToBookAddBook = navigateToBookAddBook,
            navigateToIntro = navigateToIntro,
            navigateToMyBookEdit = navigateToMyBookEdit,
        )
    }
}