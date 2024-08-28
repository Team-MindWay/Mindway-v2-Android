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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.chobo.presentation.BuildConfig
import com.chobo.presentation.R
import com.chobo.presentation.view.login.component.MindWayGAuthButton
import com.chobo.presentation.view.theme.MindWayAndroidTheme
import com.chobo.presentation.viewModel.login.LoginViewModel
import com.msg.gauthsignin.GAuthSigninWebView

@Composable
internal fun LoginRoute(
    modifier: Modifier = Modifier,
    loginViewModel: LoginViewModel = hiltViewModel(),
    navigateToHome: () -> Unit,
) {
    val (isClickLoginButton, toggleIsClickLoginButton) = remember { mutableStateOf(false) }

    LoginScreen(
        modifier = modifier,
        isClickLoginButton = isClickLoginButton,
        gAuthLogin = { gAuthCode ->
            loginViewModel.gAuthLogin(
                code = gAuthCode,
                onSuccess = navigateToHome,
            )
        },
        toggleIsClickLoginButton = { toggleIsClickLoginButton(!isClickLoginButton) }
    )
}

@Composable
internal fun LoginScreen(
    modifier: Modifier = Modifier,
    isClickLoginButton: Boolean,
    toggleIsClickLoginButton: () -> Unit,
    gAuthLogin: (String) -> Unit,
) {
    MindWayAndroidTheme { colors, _ ->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .fillMaxSize()
                .background(color = colors.WHITE)
        ) {
            Spacer(modifier = Modifier.padding(top = 220.dp))
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
        }
    }
}

@Preview
@Composable
fun PreviewLoginScreen() {
    LoginScreen(
        gAuthLogin = { _ -> },
        isClickLoginButton = false,
        toggleIsClickLoginButton = { }
    )
}