package com.chobo.presentation.view.event.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.chobo.presentation.R
import com.chobo.presentation.view.component.icon.ChevronLeftIcon
import com.chobo.presentation.view.component.topBar.MindWayOnlyStartTopAppBar

@Composable
fun DetailEventTopBar(
    startIconClick: () -> Unit
){
    MindWayOnlyStartTopAppBar(
        startIcon = { ChevronLeftIcon(modifier = Modifier.clickable(interactionSource = MutableInteractionSource(), indication = null) { startIconClick() }) },
        midText = stringResource(id = R.string.ongoing_event)
    )
}