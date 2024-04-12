package com.chobo.presentation.view.my.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.chobo.presentation.R
import com.chobo.presentation.view.component.icon.ChevronLeftIcon
import com.chobo.presentation.view.component.topBar.MindWayTopAppBar

@Composable
fun MindWayIntroTopAppBar(
    startIconOnClick: () -> Unit,
) {
    MindWayTopAppBar(
        startIcon = {
            ChevronLeftIcon(
                modifier = Modifier.clickable(
                    interactionSource = MutableInteractionSource(),
                    indication = null
                ) { startIconOnClick() }
            )
        },
        midText = stringResource(R.string.mindway_intro),
    )
}