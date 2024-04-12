package com.chobo.mindway_v2_android

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.chobo.presentation.view.book.navigation.bookAddBook
import com.chobo.presentation.view.component.compostionView.CompostionView
import com.chobo.presentation.view.component.compostionView.navigationToCompostionView
import com.chobo.presentation.view.event.navigation.detailEventScreen
import com.chobo.presentation.view.event.navigation.eventScreen
import com.chobo.presentation.view.event.navigation.navigationToDetailEvent
import com.chobo.presentation.view.login.navigation.loginScreen
import com.chobo.presentation.view.main.navigation.goalReading
import com.chobo.presentation.view.main.navigation.homeAddBook
import com.chobo.presentation.view.main.navigation.navigationToHomeAddBook
import com.chobo.presentation.view.main.navigation.navigationToViewDetail
import com.chobo.presentation.view.main.navigation.viewDetail
import com.chobo.presentation.view.my.navigation.introScreen

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
        loginScreen(navigateToHome = navController::navigationToCompostionView)

        CompostionView()

        goalReading(
            navigateToBack = navController::popBackStack,
            navigateToHomeAddBook = navController::navigationToHomeAddBook,
            navigateToHomeViewDetail = navController::navigationToViewDetail,
        )

        viewDetail(navigateToBack = navController::popBackStack)

        homeAddBook(navigateToBack = navController::popBackStack)

        eventScreen(navigateToDetailEvent = navController::navigationToDetailEvent)

        detailEventScreen(navigateToBack = navController::popBackStack)


        bookAddBook(navigateToBack = navController::popBackStack)

        introScreen(navigateToBack = navController::popBackStack)
    }
}