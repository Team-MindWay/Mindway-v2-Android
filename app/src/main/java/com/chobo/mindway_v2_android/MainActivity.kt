package com.chobo.mindway_v2_android

import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.lifecycleScope
import com.chobo.presentation.view.component.combinationView.CombinationViewRoute
import com.chobo.presentation.view.login.navigation.loginRoute
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewmodel: MainActivityViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        var uiState: MainActivityUiState by mutableStateOf(MainActivityUiState.Loading)

        lifecycleScope.launch {
            viewmodel.uiState
                .collect {
                    uiState = it
                    if (it is MainActivityUiState.Success) runCatching { viewmodel.saveLoginToken(it.gAuthLoginResponseModel) }
                }
        }

        setContent {
            installSplashScreen().apply {
                setKeepOnScreenCondition {
                    uiState is MainActivityUiState.Loading
                }
            }

            val startDestination = when (uiState) {
                is MainActivityUiState.Success -> CombinationViewRoute
                is MainActivityUiState.Fail -> loginRoute
                else -> loginRoute
            }
            MindWayNavHost(startDestination = startDestination)
        }
    }
}