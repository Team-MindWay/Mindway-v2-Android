package com.chobo.presentation.view.main.component

import androidx.compose.foundation.clickable
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.chobo.presentation.R
import com.chobo.presentation.view.component.icon.ChevronLeftIcon
import com.chobo.presentation.view.component.topBar.MindWayTopAppBar

@Composable
fun AddBookTopAppBar(startIconOnClick: () -> Unit) {
    MindWayTopAppBar(
        startIcon = { ChevronLeftIcon(modifier = Modifier.clickable { startIconOnClick() }) },
        midText = stringResource(R.string.add_book),
    )
}