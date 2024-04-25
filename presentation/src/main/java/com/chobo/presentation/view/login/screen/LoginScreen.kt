package com.chobo.presentation.view.login.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chobo.presentation.R
import com.chobo.presentation.view.login.component.MindWayGAuthButton
import com.chobo.presentation.view.theme.MindWayAndroidTheme

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    navigateToHome: () -> Unit
) {
    var isClicked by remember { mutableStateOf(false) }

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
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                MindWayGAuthButton(modifier = Modifier.height(48.dp))
                { isClicked = true }
                Spacer(modifier = Modifier.height(30.dp))
                Button(
                    onClick = { navigateToHome() }
                ) {
                    Text(text = "Button")
                }
            }
        }
    }
    /*if (isClicked) {
        GAuthSigninWebView(
            clientId = ,
            redirectUri = )
        {
        }
    } -> todo : WebView */
}

@Preview
@Composable
fun PreviewLoginScreen() {
    LoginScreen(navigateToHome = { })
}