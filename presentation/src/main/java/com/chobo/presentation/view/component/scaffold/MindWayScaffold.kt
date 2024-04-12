package com.chobo.presentation.view.component.scaffold

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import com.chobo.presentation.view.component.bottom_navigation_bar.MindWayNavBar
import com.chobo.presentation.view.component.bottom_navigation_bar.MindWayNavBarItemType
import com.chobo.presentation.view.component.topBar.MindWayTopAppBar

@Composable
fun MindWayScaffold(
    isTopAppBar: Boolean = true,
    midText: String = "",
    currentDestination: MutableState<MindWayNavBarItemType>,
    startIcon: @Composable () -> Unit = {},
    endIcon: @Composable () -> Unit = {},
    content: @Composable () -> Unit,
) {
    Scaffold(
        topBar = {
            if (isTopAppBar) {
                MindWayTopAppBar(
                    startIcon = { startIcon() },
                    midText = midText,
                    endIcon = { endIcon() },
                )
            } else {
                null
            }
        },
        bottomBar = {
            MindWayNavBar(
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