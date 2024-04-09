package com.chobo.presentation.view.main.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.chobo.presentation.view.main.screen.GoalReadingScreen
import com.chobo.presentation.view.main.screen.HomeScreen
import com.chobo.presentation.view.main.screen.ViewDetailScreen

const val homeRoute = "home_route"
const val addBookRoute = "add_book_route"
const val viewDetailRoute = "view_detail_route"
const val goalReadingRoute = "goal_reading_route"

fun NavController.navigationToHome() {
    this.navigate(homeRoute)
}

fun NavController.navigationToGoalReading() {
    this.navigate(goalReadingRoute)
}

fun NavController.navigationToViewDetail() {
    this.navigate(viewDetailRoute)
}

fun NavController.navigationToAddBook() {
    this.navigate(addBookRoute)
}


fun NavGraphBuilder.homeScreen() {
    composable(homeRoute) {
        HomeScreen()
    }
}

fun NavGraphBuilder.goalReading() {
    composable(goalReadingRoute) {
        GoalReadingScreen()
    }
}

fun NavGraphBuilder.viewDetail() {
    composable(viewDetailRoute) {
        ViewDetailScreen()
    }
}

fun NavGraphBuilder.addBook() {
    composable(addBookRoute) {
        ViewDetailScreen()
    }
}