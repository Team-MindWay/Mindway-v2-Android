package com.chobo.presentation.view.main.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.chobo.presentation.view.main.component.BookKingOfTheMonthData
import com.chobo.presentation.view.main.component.ReadingGoalGraphData
import com.chobo.presentation.view.main.screen.HomeScreen
import com.chobo.presentation.view.main.screen.MockOnClick

const val homeRoute = "home_route"

fun NavController.navigationToHome() {
    this.navigate(homeRoute)
}

fun NavGraphBuilder.homeScreen() {
    composable(homeRoute) {
        HomeScreen(
            homeNoticeCardOnClick = { MockOnClick() },
            homeGoalReadingChart = { MockOnClick() },
            readingGoalGraphDataList = listOf(
                ReadingGoalGraphData(2, 3, false, "일"),
                ReadingGoalGraphData(3, 3, false, "일"),
                ReadingGoalGraphData(2, 3, false, "일"),
                ReadingGoalGraphData(1, 3, true, "일"),
                ReadingGoalGraphData(2, 3, false, "일"),
                ReadingGoalGraphData(1, 3, false, "일"),
                ReadingGoalGraphData(2, 3, false, "일"),
            ),
            bookKingOfTheMonthDataList = listOf(
                BookKingOfTheMonthData("왕승황", 29),
                BookKingOfTheMonthData("왕성찬", 15),
                BookKingOfTheMonthData("왕지완", 1),
            )
        )
    }
}