package com.chobo.presentation.view.component.bottom_navigation_bar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chobo.presentation.R
import com.chobo.presentation.view.component.icon.BookIcon
import com.chobo.presentation.view.component.icon.HeartIcon
import com.chobo.presentation.view.component.icon.HomeIcon
import com.chobo.presentation.view.component.icon.ProfileIcon
import com.chobo.presentation.view.component.multipleEventsCutterManager.clickableSingle
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
    MindWayAndroidTheme { colors, _ ->
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = modifier
                .fillMaxWidth()
                .background(colors.WHITE)
                .padding(start = 28.dp, end = 28.dp, top = 8.dp, bottom = 20.dp),
        ) {
            listOf(
                MindWayNavBarItemType.HOME,
                MindWayNavBarItemType.EVENT,
                MindWayNavBarItemType.BOOKS,
                MindWayNavBarItemType.MY
            ).forEach { item ->
                val isCurrentDestination by remember {
                    mutableStateOf (currentDestination.value == item)
                }
                MindWayNavBarItem(
                    colors = if (!isCurrentDestination) colors.GRAY400 else colors.Black,
                    text = when (item) {
                        MindWayNavBarItemType.HOME -> stringResource(id = R.string.home)
                        MindWayNavBarItemType.EVENT -> stringResource(id = R.string.event)
                        MindWayNavBarItemType.BOOKS -> stringResource(id = R.string.books)
                        MindWayNavBarItemType.MY -> stringResource(id = R.string.my)
                    },
                    icon = {
                        when (item) {
                            MindWayNavBarItemType.HOME -> {
                                HomeIcon(
                                    isSelected = isCurrentDestination,
                                    modifier = modifier,
                                )
                            }

                            MindWayNavBarItemType.EVENT -> {
                                HeartIcon(
                                    isSelected = isCurrentDestination,
                                    modifier = modifier,
                                )
                            }

                            MindWayNavBarItemType.BOOKS -> {
                                BookIcon(
                                    isSelected = isCurrentDestination,
                                    modifier = modifier,
                                )
                            }

                            MindWayNavBarItemType.MY -> {
                                ProfileIcon(
                                    isSelected = isCurrentDestination,
                                    modifier = modifier,
                                )
                            }
                        }
                    },
                    modifier = modifier
                        .clickableSingle(
                            enabled = !isCurrentDestination,
                            onClick = {
                                currentDestination.value = item
                                when (item) {
                                    MindWayNavBarItemType.HOME -> navigateToHome()
                                    MindWayNavBarItemType.EVENT -> navigateToEvent()
                                    MindWayNavBarItemType.BOOKS -> navigateToBooks()
                                    MindWayNavBarItemType.MY -> navigateToMy()
                                }
                            }
                        )
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