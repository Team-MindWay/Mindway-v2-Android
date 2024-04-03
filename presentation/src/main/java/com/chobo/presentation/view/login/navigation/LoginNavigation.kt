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
    navigateToHome: () -> Unit
) {
    composable(loginRoute) {
        LoginScreen(
            navigateToHome = navigateToHome
        )
    }
}