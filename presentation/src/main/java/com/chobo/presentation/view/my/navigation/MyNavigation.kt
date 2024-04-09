package com.chobo.presentation.view.my.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.chobo.presentation.view.my.screen.MindWayIntroScreen
import com.chobo.presentation.view.my.screen.MyBookEditScreen
import com.chobo.presentation.view.my.screen.MyScreen

const val introRoute = "intro_route"
const val myBookEditRoute = "my_book_edit_route"
const val myRoute = "my_route"


fun NavController.navigationToIntro() {
    this.navigate(introRoute)
}

fun NavController.navigationToMy() {
    this.navigate(myRoute)
}

fun NavController.navigationToMyBookEdit() {
    this.navigate(myBookEditRoute)
}


fun NavGraphBuilder.introScreen(navigateToBack: () -> Boolean) {
    composable(introRoute) {
        MindWayIntroScreen()
    }
}

fun NavGraphBuilder.myScreen(
    navigateToMyBookEdit: () -> Unit,
    navigateToIntro: () -> Unit
) {
    composable(myRoute) {
        MyScreen()
    }
}

fun NavGraphBuilder.myBookEditScreen(
    navigateToBack: () -> Boolean,
    navigateToIntro: () -> Unit
) {
    composable(myBookEditRoute) {
        MyBookEditScreen()
    }
}