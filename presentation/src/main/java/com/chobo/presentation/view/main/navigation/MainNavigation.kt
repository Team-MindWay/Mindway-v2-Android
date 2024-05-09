package com.chobo.presentation.view.main.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.chobo.presentation.view.main.screen.GoalReadingRoute
import com.chobo.presentation.view.main.screen.HomeAddBookRoute
import com.chobo.presentation.view.main.screen.HomeEditBookRoute
import com.chobo.presentation.view.main.screen.ViewDetailRoute

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
        GoalReadingRoute(
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
        ViewDetailRoute(
            navigateToBack = navigateToBack,
            navigateToHomeEditBook = navigateToHomeEditBook,
        )
    }
}

fun NavGraphBuilder.homeAddBook(navigateToBack: () -> Unit) {
    composable(homeAddBookRoute) {
        HomeAddBookRoute(navigateToBack = navigateToBack)
    }
}

fun NavGraphBuilder.homeEditBook(navigateToBack: () -> Unit) {
    composable(homeEditBookRoute) {
        HomeEditBookRoute(navigateToBack = navigateToBack)
    }
}