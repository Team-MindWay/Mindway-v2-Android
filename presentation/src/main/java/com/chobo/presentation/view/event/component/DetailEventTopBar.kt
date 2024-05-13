package com.chobo.presentation.view.event.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.chobo.presentation.R
import com.chobo.presentation.view.component.icon.ChevronLeftIcon
import com.chobo.presentation.view.component.multipleEventsCutterManager.clickableSingle
import com.chobo.presentation.view.component.topBar.MindWayTopAppBar

@Composable
fun DetailEventTopBar(startIconOnClick: () -> Unit) {
    MindWayTopAppBar(
        startIcon = {
            ChevronLeftIcon(
                modifier = Modifier.clickableSingle(onClick = startIconOnClick)
            )
        },
        midText = stringResource(id = R.string.ongoing_event)
    )
}

@Preview(showBackground = true)
@Composable
fun DetailEventTopBarPreview() {
    DetailEventTopBar(startIconOnClick = { })
}