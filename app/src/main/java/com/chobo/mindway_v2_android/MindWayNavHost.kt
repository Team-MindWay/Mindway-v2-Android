package com.chobo.mindway_v2_android

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.chobo.presentation.view.login.navigation.loginScreen
import com.chobo.presentation.view.main.navigation.homeScreen
import com.chobo.presentation.view.main.navigation.navigationToHome

@Composable
fun MindWayNavHost(
    navController: NavHostController,
    startDestination: String
){
    val viewModelStoreOwner = checkNotNull(LocalViewModelStoreOwner.current)

    NavHost(
        navController = navController,
        startDestination = startDestination
    ){
        loginScreen(
            navigateToHome = { navController.navigationToHome() }
        )
        homeScreen()
    }
}