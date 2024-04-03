package com.chobo.presentation.view.login.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.chobo.presentation.view.login.screen.LoginScreen

const val NAVIGATION_LOGIN = "login_route"

fun NavController.navigationToLogin() {
    this.navigate(NAVIGATION_LOGIN)
}

fun NavGraphBuilder.loginScreen(
    navigateToMain: () -> Unit
) {
    composable(NAVIGATION_LOGIN) {
        LoginScreen(
            navigateToMain = navigateToMain
        )
    }
}