package com.chobo.presentation.view.event.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.chobo.presentation.view.event.screen.DetailEventScreen
import com.chobo.presentation.view.event.screen.EventScreen
import com.chobo.presentation.viewModel.event.uistate.GetDetailEventUiState
import com.chobo.presentation.viewModel.event.uistate.GetEventDateListUiState
import com.chobo.presentation.viewModel.event.uistate.GetEventListUiState

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
            navigateToDetailEvent = navigateToDetailEvent,
            getEventListUiState = GetEventListUiState.Loading,
            getDetailEventUiState = GetDetailEventUiState.Loading,
            getEventDateListUiState = GetEventDateListUiState.Loading,
            mainCallBack = { /*TODO*/ })
    }
}

fun NavGraphBuilder.detailEventScreen(
    navigateToBack: () -> Unit
) {
    composable(detailEventRoute) {
        DetailEventScreen(navigateToBack = navigateToBack)
    }
}