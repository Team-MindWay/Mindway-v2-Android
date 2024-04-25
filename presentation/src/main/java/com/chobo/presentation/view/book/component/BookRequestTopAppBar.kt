package com.chobo.presentation.view.book.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.chobo.presentation.R
import com.chobo.presentation.view.component.icon.ChevronLeftIcon
import com.chobo.presentation.view.component.icon.InfoIcon
import com.chobo.presentation.view.component.multipleEventsCutterManager.clickableSingle
import com.chobo.presentation.view.component.topBar.MindWayTopAppBar

@Composable
fun BookRequestTopAppBar(
    startIconOnClick: () -> Unit,
    endIconOnClick: () -> Unit,
) {
    MindWayTopAppBar(
        startIcon = {
            ChevronLeftIcon(modifier = Modifier.clickableSingle { startIconOnClick() })
        },
        midText = stringResource(R.string.book_request),
        endIcon = {
            InfoIcon(modifier = Modifier.clickableSingle { endIconOnClick() })
        }
    )
}

@Preview(showBackground = true)
@Composable
fun BookRequestTopAppBarPreview() {
    BookRequestTopAppBar(startIconOnClick = { }) {}
}