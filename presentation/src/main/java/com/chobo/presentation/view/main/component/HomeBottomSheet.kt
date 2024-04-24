package com.chobo.presentation.view.main.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.chobo.presentation.R
import com.chobo.presentation.view.component.bottom_sheet.MindWayBottomSheet

@Composable
fun HomeBottomSheet(
    navigateToBookEdit: () -> Unit,
    bookDeleteOnClick: () -> Unit,
) {
    MindWayBottomSheet(
        topText = stringResource(R.string.book_modify),
        bottomText = stringResource(R.string.book_delete),
        topOnClick = navigateToBookEdit,
        bottomOnCLick = bookDeleteOnClick,
    )
}