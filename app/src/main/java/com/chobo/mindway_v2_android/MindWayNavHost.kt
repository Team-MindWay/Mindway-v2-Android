package com.chobo.mindway_v2_android

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.chobo.presentation.view.book.navigation.bookAddBook
import com.chobo.presentation.view.book.navigation.navigationToBookAddBook
import com.chobo.presentation.view.component.bottom_navigation_bar.MindWayNavBarItemType
import com.chobo.presentation.view.component.compostionView.CompostionView
import com.chobo.presentation.view.component.compostionView.navigationToCompostionView
import com.chobo.presentation.view.event.navigation.detailEventScreen
import com.chobo.presentation.view.event.navigation.eventScreen
import com.chobo.presentation.view.event.navigation.navigationToDetailEvent
import com.chobo.presentation.view.login.navigation.loginScreen
import com.chobo.presentation.view.main.navigation.goalReading
import com.chobo.presentation.view.main.navigation.homeAddBook
import com.chobo.presentation.view.main.navigation.navigationToGoalReading
import com.chobo.presentation.view.main.navigation.navigationToHomeAddBook
import com.chobo.presentation.view.main.navigation.navigationToViewDetail
import com.chobo.presentation.view.main.navigation.viewDetail
import com.chobo.presentation.view.my.navigation.introScreen
import com.chobo.presentation.view.my.navigation.navigationToIntro

@Composable
fun MindWayNavHost(
    navController: NavHostController,
    startDestination: String
) {
    val viewModelStoreOwner = checkNotNull(LocalViewModelStoreOwner.current)
    val topDestination = remember {
        mutableStateOf(MindWayNavBarItemType.HOME)
    }
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        loginScreen(navigateToHome = navController::navigationToCompostionView)

        CompostionView(
            topDestination = topDestination,
            navigateToGoalReading = navController::navigationToGoalReading,
            navigateToDetailEvent = navController::navigationToDetailEvent,
            navigateToBookAddBook = navController::navigationToBookAddBook,
            navigateToIntro = navController::navigationToIntro,
        )

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