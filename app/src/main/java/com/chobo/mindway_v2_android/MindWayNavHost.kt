package com.chobo.mindway_v2_android

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.chobo.presentation.view.book.navigation.bookAddBook
import com.chobo.presentation.view.book.navigation.navigationToBookAddBook
import com.chobo.presentation.view.component.bottom_navigation_bar.MindWayNavBarItemType
import com.chobo.presentation.view.component.combinationView.combinationView
import com.chobo.presentation.view.component.combinationView.navigationToCombinationView
import com.chobo.presentation.view.event.navigation.detailEventScreen
import com.chobo.presentation.view.event.navigation.navigationToDetailEvent
import com.chobo.presentation.view.login.navigation.loginScreen
import com.chobo.presentation.view.login.navigation.navigationToLogin
import com.chobo.presentation.view.main.navigation.goalReading
import com.chobo.presentation.view.main.navigation.homeAddBook
import com.chobo.presentation.view.main.navigation.homeEditBook
import com.chobo.presentation.view.main.navigation.navigationToGoalReading
import com.chobo.presentation.view.main.navigation.navigationToHomeAddBook
import com.chobo.presentation.view.main.navigation.navigationToHomeEditBook
import com.chobo.presentation.view.main.navigation.navigationToViewDetail
import com.chobo.presentation.view.main.navigation.viewDetail
import com.chobo.presentation.view.my.navigation.introScreen
import com.chobo.presentation.view.my.navigation.myBookEditScreen
import com.chobo.presentation.view.my.navigation.navigationToIntro
import com.chobo.presentation.view.my.navigation.navigationToMyBookEdit

@Composable
fun MindWayNavHost(
    navController: NavHostController = rememberNavController(),
    startDestination: String,
) {
    val topDestination = remember {
        mutableStateOf(MindWayNavBarItemType.HOME)
    }
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        loginScreen(navigateToHome = navController::navigationToCombinationView)

        combinationView(
            topDestination = topDestination,
            navigateToGoalReading = navController::navigationToGoalReading,
            navigateToDetailEvent = navController::navigationToDetailEvent,
            navigateToBookAddBook = navController::navigationToBookAddBook,
            navigateToIntro = navController::navigationToIntro,
            navigateToMyBookEdit = navController::navigationToMyBookEdit,
            navigateToLogin = navController::navigationToLogin
        )

        goalReading(
            navigateToBack = navController::popBackStack,
            navigateToHomeAddBook = navController::navigationToHomeAddBook,
            navigateToHomeViewDetail = navController::navigationToViewDetail,
        )

        viewDetail(
            navigateToBack = navController::popBackStack,
            navigateToHomeEditBook = navController::navigationToHomeEditBook
        )

        homeAddBook(navigateToBack = navController::popBackStack)

        homeEditBook(navigateToBack = navController::popBackStack)

        detailEventScreen(navigateToBack = navController::popBackStack,)

        bookAddBook(navigateToBack = navController::popBackStack)

        myBookEditScreen(navigateToBack = navController::popBackStack)

        introScreen(navigateToBack = navController::popBackStack)
    }
}