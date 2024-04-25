package com.chobo.mindway_v2_android

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.chobo.presentation.view.book.navigation.bookAddBookScreen
import com.chobo.presentation.view.book.navigation.navigationToBookAddBook
import com.chobo.presentation.view.component.bottom_navigation_bar.MindWayNavBarItemType
import com.chobo.presentation.view.component.compostionView.combinationScreen
import com.chobo.presentation.view.component.compostionView.navigationToCombinationView
import com.chobo.presentation.view.event.navigation.detailEventScreen
import com.chobo.presentation.view.event.navigation.eventScreenScreen
import com.chobo.presentation.view.event.navigation.navigationToDetailEvent
import com.chobo.presentation.view.login.navigation.loginScreen
import com.chobo.presentation.view.main.navigation.goalReadingScreen
import com.chobo.presentation.view.main.navigation.homeAddBookScreen
import com.chobo.presentation.view.main.navigation.homeEditBookScreen
import com.chobo.presentation.view.main.navigation.navigationToGoalReading
import com.chobo.presentation.view.main.navigation.navigationToHomeAddBook
import com.chobo.presentation.view.main.navigation.navigationToHomeEditBook
import com.chobo.presentation.view.main.navigation.navigationToViewDetail
import com.chobo.presentation.view.main.navigation.viewDetailScreen
import com.chobo.presentation.view.my.navigation.introScreen
import com.chobo.presentation.view.my.navigation.myBookEditScreen
import com.chobo.presentation.view.my.navigation.navigationToIntro
import com.chobo.presentation.view.my.navigation.navigationToMyBookEdit

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
        loginScreen(navigateToHome = navController::navigationToCombinationView)

        combinationScreen(
            topDestination = topDestination,
            navigateToGoalReading = navController::navigationToGoalReading,
            navigateToDetailEvent = navController::navigationToDetailEvent,
            navigateToBookAddBook = navController::navigationToBookAddBook,
            navigateToIntro = navController::navigationToIntro,
            navigateToMyBookEdit = navController::navigationToMyBookEdit,
        )

        goalReadingScreen(
            navigateToBack = navController::popBackStack,
            navigateToHomeAddBook = navController::navigationToHomeAddBook,
            navigateToHomeViewDetail = navController::navigationToViewDetail,
        )

        viewDetailScreen(
            navigateToBack = navController::popBackStack,
            navigateToHomeEditBook = navController::navigationToHomeEditBook
        )

        homeAddBookScreen(navigateToBack = navController::popBackStack)

        homeEditBookScreen(navigateToBack = navController::popBackStack)

        eventScreenScreen(navigateToDetailEvent = navController::navigationToDetailEvent)

        detailEventScreen(navigateToBack = navController::popBackStack)

        bookAddBookScreen(navigateToBack = navController::popBackStack)

        myBookEditScreen(navigateToBack = navController::popBackStack)

        introScreen(navigateToBack = navController::popBackStack)
    }
}