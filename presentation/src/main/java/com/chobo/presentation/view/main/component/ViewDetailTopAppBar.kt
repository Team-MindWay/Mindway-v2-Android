package com.chobo.presentation.view.main.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.chobo.presentation.R
import com.chobo.presentation.view.component.icon.ChevronLeftIcon
import com.chobo.presentation.view.component.icon.OptionIcon
import com.chobo.presentation.view.component.topBar.MindWayTopAppBar

@Composable
fun ViewDetailTopAppBar(
    startIconOnClick: () -> Unit,
    endIconOnClick: () -> Unit,
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
        endIcon = {
                  OptionIcon(
                      modifier = Modifier.clickable(
                          interactionSource = MutableInteractionSource(),
                          indication = null
                      ) { endIconOnClick() }
                  )
        },
        midText = stringResource(R.string.view_detail),
    )
}

@Preview(showBackground = true)
@Composable
fun ViewDetailTopAppBarPreview() {
    ViewDetailTopAppBar(startIconOnClick = { }, endIconOnClick = { })
}