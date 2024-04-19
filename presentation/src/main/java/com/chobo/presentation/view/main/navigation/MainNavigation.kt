package com.chobo.presentation.view.main.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.chobo.presentation.view.main.screen.GoalReadingScreen
import com.chobo.presentation.view.main.screen.HomeAddBookScreen
import com.chobo.presentation.view.main.screen.HomeEditBookScreen
import com.chobo.presentation.view.main.screen.ViewDetailScreen

const val homeAddBookRoute = "home_add_book_route"
const val viewDetailRoute = "view_detail_route"
const val goalReadingRoute = "goal_reading_route"
const val homeEditBookRoute = "home_book_edit_route"

fun NavController.navigationToGoalReading() {
    this.navigate(goalReadingRoute)
}

fun NavController.navigationToViewDetail() {
    this.navigate(viewDetailRoute)
}

fun NavController.navigationToHomeAddBook() {
    this.navigate(homeAddBookRoute)
}

fun NavController.navigationToHomeEditBook() {
    this.navigate(homeEditBookRoute)
}

fun NavGraphBuilder.goalReading(
    navigateToBack: () -> Unit,
    navigateToHomeAddBook: () -> Unit,
    navigateToHomeViewDetail: () -> Unit
) {
    composable(goalReadingRoute) {
        GoalReadingScreen(
            navigateToBack = navigateToBack,
            navigateToHomeAddBook = navigateToHomeAddBook,
            navigateToHomeViewDetail = navigateToHomeViewDetail,
        )
    }
}

fun NavGraphBuilder.viewDetail(
    navigateToBack: () -> Unit,
    navigateToHomeEditBook: () -> Unit
) {
    composable(viewDetailRoute) {
        ViewDetailScreen(
            navigateToBack = navigateToBack,
            navigateToHomeEditBook = navigateToHomeEditBook
        )
    }
}

fun NavGraphBuilder.homeAddBook(navigateToBack: () -> Unit) {
    composable(homeAddBookRoute) {
        HomeAddBookScreen(navigateToBack = navigateToBack)
    }
}

fun NavGraphBuilder.homeEditBook(navigateToBack: () -> Unit) {
    composable(homeEditBookRoute) {
        HomeEditBookScreen(navigateToBack = navigateToBack)
    }
}