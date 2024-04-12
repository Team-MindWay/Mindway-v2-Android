package com.chobo.presentation.view.my.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.chobo.presentation.view.my.screen.MindWayIntroScreen
import com.chobo.presentation.view.my.screen.MyBookEditScreen
import com.chobo.presentation.view.my.screen.MyScreen

const val introRoute = "intro_route"


fun NavController.navigationToIntro() {
    this.navigate(introRoute)
}

fun NavGraphBuilder.introScreen(navigateToBack: () -> Boolean) {
    composable(introRoute) {
        MindWayIntroScreen()
    }
}
