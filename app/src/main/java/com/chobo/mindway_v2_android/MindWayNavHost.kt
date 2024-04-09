package com.chobo.mindway_v2_android

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.chobo.presentation.view.book.navigation.book
import com.chobo.presentation.view.book.navigation.bookAddBook
import com.chobo.presentation.view.book.navigation.navigationToBookAddBook
import com.chobo.presentation.view.event.navigation.detailEventScreen
import com.chobo.presentation.view.event.navigation.eventScreen
import com.chobo.presentation.view.event.navigation.navigationToDetailEvent
import com.chobo.presentation.view.login.navigation.loginScreen
import com.chobo.presentation.view.main.navigation.goalReading
import com.chobo.presentation.view.main.navigation.homeAddBook
import com.chobo.presentation.view.main.navigation.homeScreen
import com.chobo.presentation.view.main.navigation.navigationToGoalReading
import com.chobo.presentation.view.main.navigation.navigationToHome
import com.chobo.presentation.view.main.navigation.navigationToHomeAddBook
import com.chobo.presentation.view.main.navigation.navigationToViewDetail
import com.chobo.presentation.view.main.navigation.viewDetail
import com.chobo.presentation.view.my.navigation.introScreen
import com.chobo.presentation.view.my.navigation.myBookEditScreen
import com.chobo.presentation.view.my.navigation.myScreen
import com.chobo.presentation.view.my.navigation.navigationToIntro
import com.chobo.presentation.view.my.navigation.navigationToMyBookEdit

@Composable
fun MindWayNavHost(
    navController: NavHostController,
    startDestination: String
) {
    val viewModelStoreOwner = checkNotNull(LocalViewModelStoreOwner.current)

    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {

        loginScreen(navigateToHome = navController::navigationToHome)

        homeScreen(
            navigateToGoalReading = navController::navigationToGoalReading,
            navigateToDetailEvent = navController::navigationToDetailEvent
        )

        goalReading(
            navigateToBack = navController::popBackStack,
            navigateToHomeAddBook = navController::navigationToHomeAddBook,
            navigateToHomeViewDetail = navController::navigationToViewDetail,
        )

        viewDetail(navigateToBack = navController::popBackStack)

        homeAddBook(navigateToBack = navController::popBackStack)

        eventScreen(navigateToDetailEvent = navController::navigationToDetailEvent)

        detailEventScreen(navigateToEvent = navController::popBackStack)

        book(
            navigateToBookAddBook = navController::navigationToBookAddBook,
            navigateToHomeViewDetail = navController::navigationToViewDetail,
        )

        bookAddBook(navigateToBack = navController::popBackStack)

        myScreen(
            navigateToMyBookEdit = navController::navigationToMyBookEdit,
            navigateToIntro = navController::navigationToIntro,
        )

        myBookEditScreen(
            navigateToBack = navController::popBackStack,
            navigateToIntro = navController::navigationToIntro
        )

        introScreen(navigateToBack = navController::popBackStack)
    }
}