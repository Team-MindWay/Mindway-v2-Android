package com.chobo.presentation.view.login.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.chobo.presentation.BuildConfig
import com.chobo.presentation.R
import com.chobo.presentation.view.login.component.MindWayGAuthButton
import com.chobo.presentation.view.theme.MindWayAndroidTheme
import com.chobo.presentation.viewModel.auth.AuthViewModel
import com.chobo.presentation.viewModel.auth.uistate.AuthUiState
import com.msg.gauthsignin.GAuthSigninWebView

@Composable
internal fun LoginRoute(
    modifier: Modifier = Modifier,
    authViewModel: AuthViewModel = hiltViewModel(),
    navigateToHome: () -> Unit,
) {
    val authUiState by authViewModel.authUiState.collectAsStateWithLifecycle()
    val isSuccessSaveLoginData by authViewModel.isSuccessSaveLoginData.collectAsStateWithLifecycle()

    LoginScreen(
        modifier = modifier,
        gAuthLogin = authViewModel::gAuthLogin,
    )

    LaunchedEffect(authUiState, isSuccessSaveLoginData) {
        if (
            authUiState is AuthUiState.Success
            && isSuccessSaveLoginData
        ) navigateToHome()
    }
}

@Composable
internal fun LoginScreen(
    modifier: Modifier = Modifier,
    gAuthLogin: (String) -> Unit,
) {
    val (isClickLoginButton, toggleIsClickLoginButton) = remember { mutableStateOf(false) }

    MindWayAndroidTheme { colors, _ ->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .fillMaxSize()
                .background(color = colors.WHITE)
        ) {
            Spacer(modifier = Modifier.height(220.dp))
            Image(
                painter = painterResource(id = R.drawable.mind_way_logo),
                contentDescription = "MindWay Main logo",
            )
            Spacer(modifier = Modifier.weight(1f))
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = 24.dp,
                        end = 24.dp,
                        bottom = 140.dp
                    ),
            ) {
                MindWayGAuthButton(
                    onClick = { toggleIsClickLoginButton(true) },
                    modifier = Modifier.height(48.dp),
                )
            }
        }
    }
    if (isClickLoginButton) {
        GAuthSigninWebView(
            clientId = BuildConfig.CLIENT_ID,
            redirectUri = BuildConfig.REDIRECT_URI,
        ) { code ->
            gAuthLogin(code)
        }
    }
}

@Preview
@Composable
fun PreviewLoginScreen() {
    LoginScreen(
        gAuthLogin = { _ -> },
    )
}