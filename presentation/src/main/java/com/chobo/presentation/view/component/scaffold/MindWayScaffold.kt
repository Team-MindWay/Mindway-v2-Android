package com.chobo.presentation.view.component.scaffold

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import com.chobo.presentation.view.component.bottom_navigation_bar.MindWayNavBar
import com.chobo.presentation.view.component.bottom_navigation_bar.MindWayNavBarItemType
import com.chobo.presentation.view.component.topBar.MindWayTopAppBar
import com.chobo.presentation.view.theme.MindWayAndroidTheme

@Composable
fun MindWayScaffold(
    isTopAppBar: Boolean = true,
    midText: String = "",
    currentDestination: MutableState<MindWayNavBarItemType>,
    startIcon: @Composable () -> Unit = {},
    content: @Composable () -> Unit,
) {
    MindWayAndroidTheme { colors, _ ->
        Scaffold(
            topBar = {
                if (isTopAppBar) {
                    MindWayTopAppBar(
                        modifier = Modifier.background(color = colors.WHITE),
                        startIcon = { startIcon() },
                        midText = midText,
                    )
                }
            },
            bottomBar = {
                MindWayNavBar(
                    currentDestination = currentDestination,
                    navigateToHome = { currentDestination.value = MindWayNavBarItemType.HOME },
                    navigateToEvent = { currentDestination.value = MindWayNavBarItemType.EVENT },
                    navigateToBooks = { currentDestination.value = MindWayNavBarItemType.BOOKS },
                    navigateToMy = { currentDestination.value = MindWayNavBarItemType.MY }
                )
            }
        ) { PaddingValues ->
            Column(modifier = Modifier.padding(PaddingValues)) {
                content()
            }
        }
    }
}