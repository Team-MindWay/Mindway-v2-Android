package com.chobo.presentation.view.component.bottom_navigation_bar

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chobo.presentation.view.theme.MindWayAndroidTheme

@Composable
fun MindWayNavBar(
    modifier: Modifier = Modifier
) {
    val itemList = listOf(
        MindWayNavBarItemType.HOME,
        MindWayNavBarItemType.EVENT,
        MindWayNavBarItemType.BOOKS,
        MindWayNavBarItemType.MY
    )

    MindWayAndroidTheme { colors, _ ->
        Row(
            modifier = modifier
                .fillMaxWidth()
                .background(colors.WHITE)
                .padding(
                    start = 28.dp,
                    end = 28.dp,
                    top = 8.dp,
                    bottom = 32.dp
                ),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            repeat(itemList.size) {
                MindWayNavBarItem(
                    modifier = modifier
                        .clickable(
                            interactionSource = MutableInteractionSource(),
                            indication = null,
                            onClick = {

                            }
                        ),
                    type = itemList[it]
                )
            }
        }
    }
}

@Preview
@Composable
fun MindWayNavBarPre() {
    MindWayNavBar()
}