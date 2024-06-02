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

fun NavController.navigationToViewDetail(id: Long) {
    this.navigate("${viewDetailRoute}/${id}")
}

fun NavController.navigationToHomeAddBook() {
    this.navigate(homeAddBookRoute)
}

fun NavController.navigationToHomeEditBook(id: Long) {
    this.navigate("${homeEditBookRoute}/${id}")
}

fun NavGraphBuilder.goalReading(
    navigateToBack: () -> Unit,
    navigateToHomeAddBook: () -> Unit,
    navigateToHomeViewDetail: (Long) -> Unit,
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
    navigateToHomeEditBook: (Long) -> Unit,
) {
    composable("${viewDetailRoute}/{id}") { backStackEntry ->
        val id = backStackEntry.arguments?.getString("id")?.toLongOrNull()
        if (id != null) {
            ViewDetailRoute(
                id = id,
                navigateToBack = navigateToBack,
                navigateToHomeEditBook = navigateToHomeEditBook,
            )
        }
    }
}

fun NavGraphBuilder.homeAddBook(navigateToBack: () -> Unit) {
    composable(homeAddBookRoute) {
        HomeAddBookRoute(navigateToBack = navigateToBack)
    }
}

fun NavGraphBuilder.homeEditBook(navigateToBack: () -> Unit) {
    composable("${homeEditBookRoute}/${id}") { backStackEntry ->
        val id = backStackEntry.arguments?.getString("id")?.toLongOrNull()
        if (id != null) {
            HomeEditBookRoute(
                id = id,
                navigateToBack = navigateToBack
            )
        }
    }
}