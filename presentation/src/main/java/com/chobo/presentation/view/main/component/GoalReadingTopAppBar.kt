package com.chobo.presentation.view.main.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.chobo.presentation.R
import com.chobo.presentation.view.component.icon.ChevronLeftIcon
import com.chobo.presentation.view.component.icon.PlusIcon
import com.chobo.presentation.view.component.multipleEventsCutterManager.clickableSingle
import com.chobo.presentation.view.component.topBar.MindWayTopAppBar
import com.chobo.presentation.view.theme.color.MindWayColor

@Composable
fun GoalReadingTopAppBar(
    isData: Boolean,
    startIconOnClick: () -> Unit,
    endIconOnClick: () -> Unit,
) {
    MindWayTopAppBar(
        startIcon = {
            ChevronLeftIcon(
                modifier = Modifier.clickableSingle(onClick = startIconOnClick)
            )
        },
        midText = stringResource(R.string.goal_reading),
        endIcon = {
            if (isData) {
                PlusIcon(
                    modifier = Modifier.clickableSingle(onClick = endIconOnClick),
                    tint = MindWayColor.Black
                )
            }
            else { PlusIcon(tint = MindWayColor.GRAY400) }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun GoalReadingTopAppBarPreview() {
    GoalReadingTopAppBar(startIconOnClick = { }, isData = false) { }
}