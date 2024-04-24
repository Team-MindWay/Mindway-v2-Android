package com.chobo.presentation.view.component.bottom_navigation_bar

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chobo.presentation.view.theme.MindWayAndroidTheme

@Composable
fun MindWayNavBar(
    modifier: Modifier = Modifier,
    navigateToHome: () -> Unit,
    navigateToEvent: () -> Unit,
    navigateToBooks: () -> Unit,
    navigateToMy: () -> Unit,
    currentDestination: MutableState<MindWayNavBarItemType>,
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
                .padding(start = 28.dp, end = 28.dp, top = 8.dp, bottom = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            itemList.forEach { item ->
                MindWayNavBarItem(
                    modifier = modifier
                        .clickable(
                            interactionSource = MutableInteractionSource(),
                            indication = null,
                            onClick = {
                                if (currentDestination.value != item) {
                                    currentDestination.value = item
                                    when (item) {
                                        MindWayNavBarItemType.HOME -> navigateToHome()
                                        MindWayNavBarItemType.EVENT -> navigateToEvent()
                                        MindWayNavBarItemType.BOOKS -> navigateToBooks()
                                        MindWayNavBarItemType.MY -> navigateToMy()
                                    }
                                }
                            }
                        ),
                    type = item,
                    isSelected = currentDestination.value == item
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MindWayNavBarPre() {
    val topDestination = remember {
        mutableStateOf(MindWayNavBarItemType.HOME)
    }
    MindWayNavBar(
        navigateToHome = {},
        navigateToEvent = {},
        navigateToBooks = {},
        navigateToMy = {},
        currentDestination = topDestination
    )
}