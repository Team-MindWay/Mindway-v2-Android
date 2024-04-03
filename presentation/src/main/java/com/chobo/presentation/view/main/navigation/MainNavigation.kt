package com.chobo.presentation.view.main.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.chobo.presentation.view.main.screen.HomeScreen

const val mainRoute = "main_route"

fun NavController.navigateToMain() {
    this.navigate(mainRoute)
}

fun NavGraphBuilder.mainScreen() {
    composable(mainRoute) {
        HomeScreen()
    }
}