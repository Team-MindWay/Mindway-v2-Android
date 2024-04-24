package com.chobo.presentation.view.my.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.chobo.presentation.R
import com.chobo.presentation.view.component.bottom_sheet.MindWayBottomSheet

@Composable
fun MyBottomSheet(
    navigateToIntro: () -> Unit,
    logoutOnClick: () -> Unit,
) {
    MindWayBottomSheet(
        topText = stringResource(R.string.mindway_intro),
        bottomText = stringResource(R.string.logout),
        topOnClick = navigateToIntro,
        bottomOnCLick = logoutOnClick
    )
}

@Preview(showBackground = true)
@Composable
fun MyBottomSheetPreview() {
    MyBottomSheet(
        logoutOnClick = { },
        navigateToIntro = { },
    )
}