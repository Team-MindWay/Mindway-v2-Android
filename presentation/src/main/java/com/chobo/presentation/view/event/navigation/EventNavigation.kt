package com.chobo.presentation.view.event.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.chobo.presentation.view.event.screen.DetailEventRoute

const val detailEventRoute = "detail_event_route"

fun NavController.navigationToDetailEvent(id: Long) {
    this.navigate("${detailEventRoute}}/${id}")
}

fun NavGraphBuilder.detailEventScreen(
    navigateToBack: () -> Unit,
) {
    composable(detailEventRoute) {backStackEntry ->
        val id = backStackEntry.arguments?.getString("id")?.toLongOrNull()
        if(id != null) {
            DetailEventRoute(
                id = id,
                navigateToBack = navigateToBack
            )
        }
    }
}