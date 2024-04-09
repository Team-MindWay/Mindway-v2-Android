package com.chobo.presentation.view.event.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.chobo.presentation.view.event.screen.EventScreen

const val eventRoute = "event_route"

fun NavController.navigationToEvent() {
    this.navigate(eventRoute)
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