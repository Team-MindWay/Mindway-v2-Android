package com.chobo.presentation.view.login.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.chobo.presentation.view.login.screen.LoginScreen

const val loginRoute = "login_route"

fun NavController.navigationToLogin() {
    this.navigate(loginRoute)
}

fun NavGraphBuilder.loginScreen(
    navigateToMain: () -> Unit
) {
    composable(loginRoute) {
        LoginScreen(
            navigateToMain = navigateToMain
        )
    }
}