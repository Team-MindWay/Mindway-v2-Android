package com.chobo.presentation.view.main.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.chobo.presentation.view.main.screen.HomeScreen

const val homeRoute = "home_route"

fun NavController.navigateToMain() {
    this.navigate(homeRoute)
}

fun NavGraphBuilder.mainScreen() {
    composable(homeRoute) {
        HomeScreen()
    }
}