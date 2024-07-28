package com.chobo.mindway_v2_android

import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.getValue
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.chobo.presentation.view.component.combinationView.CombinationViewRoute
import com.chobo.presentation.view.login.navigation.loginRoute
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        installSplashScreen().setKeepOnScreenCondition {
            viewModel.uiState.value is MainActivityUiState.Loading
        }

        setContent {
            val startDestination = when (viewModel.uiState.value) {
                is MainActivityUiState.Success -> CombinationViewRoute
                else -> loginRoute
            }

            MindWayNavHost(startDestination = startDestination)
        }
    }
}