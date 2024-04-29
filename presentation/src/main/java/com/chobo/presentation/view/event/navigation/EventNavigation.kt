package com.chobo.presentation.view.event.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.chobo.presentation.view.event.screen.DetailEventScreen
import com.chobo.presentation.view.event.screen.EventScreen

const val eventRoute = "event_route"
const val detailEventRoute = "detail_event_route"

fun NavController.navigationToEvent() {
    this.navigate(eventRoute)
}

fun NavController.navigationToDetailEvent() {
    this.navigate(detailEventRoute)
}

fun NavGraphBuilder.eventScreen(
    navigateToDetailEvent: () -> Unit
) {
    composable(eventRoute) {
        EventScreen(
            navigateToDetailEvent = navigateToDetailEvent
        )
    }
}

fun NavGraphBuilder.detailEventScreen(
    navigateToBack: () -> Unit
) {
    composable(detailEventRoute) {
        DetailEventScreen(navigateToBack = navigateToBack)
    }
}