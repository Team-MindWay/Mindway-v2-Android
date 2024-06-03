package com.chobo.presentation.view.login.screen

import androidx.activity.ComponentActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.chobo.presentation.BuildConfig
import com.chobo.presentation.R
import com.chobo.presentation.view.login.component.MindWayGAuthButton
import com.chobo.presentation.view.theme.MindWayAndroidTheme
import com.chobo.presentation.viewModel.auth.AuthViewModel
import com.msg.gauthsignin.GAuthSigninWebView

@Composable
internal fun LoginRoute(
    modifier: Modifier = Modifier,
    navigateToHome: () -> Unit,
    authViewModel: AuthViewModel = viewModel(LocalContext.current as ComponentActivity)
) {
    val isClickLoginButton by authViewModel.isClickLoginButton.collectAsStateWithLifecycle()

    LoginScreen(
        modifier = modifier,
        isClickLoginButton = isClickLoginButton,
        gAuthLogin = authViewModel::gAuthLogin,
        toggleIsClickLoginButton = authViewModel::toggleIsClickLoginButton,
        navigateToHome = navigateToHome,
    )
}

@Composable
internal fun LoginScreen(
    modifier: Modifier = Modifier,
    isClickLoginButton: Boolean,
    gAuthLogin: (String) -> Unit,
    toggleIsClickLoginButton: () -> Unit,
    navigateToHome: () -> Unit,
) {

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
            Spacer(modifier = Modifier.height(302.dp))
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp),
            ) {
                MindWayGAuthButton(
                    onClick = toggleIsClickLoginButton,
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
            navigateToHome()
        }
    }
}

@Preview
@Composable
fun PreviewLoginScreen() {
    LoginRoute(navigateToHome = { })
}