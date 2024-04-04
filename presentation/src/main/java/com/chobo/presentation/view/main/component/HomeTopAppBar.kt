package com.chobo.presentation.view.main.component

import androidx.compose.foundation.clickable
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.chobo.presentation.view.component.icon.LogoIcon
import com.chobo.presentation.view.component.topBar.MindWayTopAppBar

@Composable
fun HomeTopAppBar(startIconOnClick: () -> Unit) {
    MindWayTopAppBar(
        startIcon = { LogoIcon(modifier = Modifier.clickable { startIconOnClick() }) },
    )
}