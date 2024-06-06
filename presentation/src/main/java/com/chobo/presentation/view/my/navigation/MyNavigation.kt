package com.chobo.presentation.view.my.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.chobo.presentation.view.my.screen.MindWayIntroRoute
import com.chobo.presentation.view.my.screen.MyBookEditRoute

const val introRoute = "intro_route"
const val myBookEditRoute = "my_book_edit_route"

fun NavController.navigationToIntro() {
    this.navigate(introRoute)
}

fun NavController.navigationToMyBookEdit(id: Long) {
    this.navigate("${myBookEditRoute}/${id}")
}


fun NavGraphBuilder.introScreen(navigateToBack: () -> Unit) {
    composable(introRoute) {
        MindWayIntroRoute(navigateToBack = navigateToBack)
    }
}

fun NavGraphBuilder.myBookEditScreen(navigateToBack: () -> Unit) {
    composable("${myBookEditRoute}/{id}") { backStackEntry ->
        val id = backStackEntry.arguments?.getString("id")?.toLongOrNull()
        if (id != null) {
            MyBookEditRoute(
                id = id,
                navigateToBack = navigateToBack
            )
        }
    }
}