package com.chobo.presentation.view.event.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.chobo.presentation.view.event.screen.DetailEventRoute

const val detailEventRoute = "detail_event_route"

fun NavController.navigationToDetailEvent() {
    this.navigate(detailEventRoute)
}

fun NavGraphBuilder.eventScreen(
    navigateToDetailEvent: () -> Unit
) {
    composable(eventRoute) {
        EventScreen(
            navigateToDetailEvent = navigateToDetailEvent,
            getEventListUiState = GetEventListUiState.Loading,
            getDetailEventUiState = GetDetailEventUiState.Loading,
            getEventDateListUiState = GetEventDateListUiState.Loading,
            mainCallBack = {  })
    }
}

fun NavGraphBuilder.detailEventScreen(
    navigateToBack: () -> Unit
) {
    composable(detailEventRoute) {
        DetailEventScreen(navigateToBack = navigateToBack)
    }
}