package com.chobo.presentation.view.main.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.chobo.presentation.view.main.screen.HomeScreen

const val NAVIGATION_MAIN = "main_route"

fun NavController.navigateToMain() {
    this.navigate(NAVIGATION_MAIN)
}

fun NavGraphBuilder.mainScreen() {
    composable(NAVIGATION_MAIN) {
        HomeScreen()
    }
}