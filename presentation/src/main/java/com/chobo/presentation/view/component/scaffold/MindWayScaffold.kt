package com.chobo.presentation.view.component.scaffold

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.structuralEqualityPolicy
import androidx.compose.ui.Modifier
import com.chobo.presentation.view.component.bottom_navigation_bar.MindWayNavBar
import com.chobo.presentation.view.component.topBar.MindWayTopAppBar

data class BottomNavFun(
    val navigateToHome: () -> Unit,
    val navigateToEvent: () -> Unit,
    val navigateToBooks: () -> Unit,
    val navigateToMy: () -> Unit,
)

@Composable
fun MindWayScaffold(
    bottomNavFun: BottomNavFun,
    isTopAppBar: Boolean = true,
    midText:String = "",
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
                navigateToHome = { bottomNavFun.navigateToHome },
                navigateToEvent = { bottomNavFun.navigateToEvent },
                navigateToBooks = { bottomNavFun.navigateToBooks },
                navigateToMy = { bottomNavFun.navigateToMy }
            )
        }
    ) { PaddingValues ->
        Column(modifier = Modifier.padding(PaddingValues)) {
            content()
        }
    }
}