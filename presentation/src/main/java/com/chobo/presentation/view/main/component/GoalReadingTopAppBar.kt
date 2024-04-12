package com.chobo.presentation.view.main.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.chobo.presentation.R
import com.chobo.presentation.view.component.icon.ChevronLeftIcon
import com.chobo.presentation.view.component.icon.PlusIcon
import com.chobo.presentation.view.component.topBar.MindWayTopAppBar
import com.chobo.presentation.view.theme.color.MindWayColor

@Composable
fun GoalReadingTopAppBar(
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
        midText = stringResource(R.string.goal_reading),
        endIcon = {
            PlusIcon(
                modifier = Modifier.clickable(
                    interactionSource = MutableInteractionSource(),
                    indication = null
                ) { endIconOnClick() },
                tint = MindWayColor.Black
            )
        }
    )
}
@Preview(showBackground = true)
@Composable
fun GoalReadingTopAppBarPreview(){
    GoalReadingTopAppBar(startIconOnClick = { }) { }
}