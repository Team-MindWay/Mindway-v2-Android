package com.chobo.presentation.view.my.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.chobo.presentation.view.my.screen.MindWayIntroScreen
import com.chobo.presentation.view.my.screen.MyBookEditRoute

const val introRoute = "intro_route"
const val myBookEditRoute = "my_book_edit_route"

fun NavController.navigationToIntro() {
    this.navigate(introRoute)
}

fun NavController.navigationToMyBookEdit() {
    this.navigate(myBookEditRoute)
}


fun NavGraphBuilder.introScreen(navigateToBack: () -> Unit) {
    composable(introRoute) {
        MindWayIntroScreen(navigateToBack = navigateToBack)
    }
}

fun NavGraphBuilder.myBookEditScreen(navigateToBack: () -> Unit) {
    composable(myBookEditRoute) {
        MyBookEditRoute(navigateToBack = navigateToBack)
    }
}