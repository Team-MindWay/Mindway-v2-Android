package com.chobo.presentation.view.event.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.chobo.presentation.view.event.screen.DetailEventScreen

const val detailEventRoute = "detail_event_route"

fun NavController.navigationToDetailEvent() {
    this.navigate(detailEventRoute)
}

fun NavGraphBuilder.detailEventScreen(
    navigateToEvent: () -> Unit,
) {
    composable(eventRoute) {
        DetailEventScreen(
            navigateToEvent = navigateToEvent,
        )
    }
}