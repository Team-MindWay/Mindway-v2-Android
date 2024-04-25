package com.chobo.presentation.view.my.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.chobo.presentation.R
import com.chobo.presentation.view.component.icon.ChevronLeftIcon
import com.chobo.presentation.view.component.multipleEventsCutterManager.clickableSingle
import com.chobo.presentation.view.component.topBar.MindWayTopAppBar

@Composable
fun MindWayIntroTopAppBar(
    startIconOnClick: () -> Unit,
) {
    MindWayTopAppBar(
        startIcon = {
            ChevronLeftIcon(modifier = Modifier.clickableSingle { startIconOnClick() })
        },
        midText = stringResource(R.string.mindway_intro),
    )
}

@Preview(showBackground = true)
@Composable
fun MindWayIntroTopAppBarPreview() {
    MindWayIntroTopAppBar(startIconOnClick = { })
}