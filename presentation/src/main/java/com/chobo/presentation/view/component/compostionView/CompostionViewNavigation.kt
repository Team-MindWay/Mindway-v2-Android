package com.chobo.presentation.view.component.compostionView

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

const val CompostionViewRoute = "copmostion_view_route"

fun NavController.navigationToCompostionView() {
    this.navigate(CompostionViewRoute)
}

fun NavGraphBuilder.CompostionView() {
    composable(CompostionViewRoute) {
        MindWayCombinationView()
    }
}