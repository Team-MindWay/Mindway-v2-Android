package com.chobo.presentation.view.component.bottom_navigation_bar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chobo.presentation.R
import com.chobo.presentation.view.component.bottom_navigation_bar.MindWayNavBarItemType.*
import com.chobo.presentation.view.component.icon.BookIcon
import com.chobo.presentation.view.component.icon.HeartIcon
import com.chobo.presentation.view.component.icon.HomeIcon
import com.chobo.presentation.view.component.icon.ProfileIcon
import com.chobo.presentation.view.component.multipleEventsCutterManager.clickableSingle
import com.chobo.presentation.view.theme.MindWayAndroidTheme

@Composable
fun MindWayNavBar(
    modifier: Modifier = Modifier,
    currentDestination: MindWayNavBarItemType,
    setCurrentDestination: (MindWayNavBarItemType) -> Unit,
) {
    MindWayAndroidTheme { colors, _ ->
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = modifier
                .fillMaxWidth()
                .background(colors.WHITE)
                .padding(start = 28.dp, end = 28.dp, top = 8.dp, bottom = 20.dp),
        ) {
            MindWayNavBarItemType.values().forEach { item ->
                MindWayNavBarItem(
                    colors = if (currentDestination != item) colors.GRAY400 else colors.Black,
                    text = when (item) {
                        HOME -> stringResource(id = R.string.home)
                        EVENT -> stringResource(id = R.string.event)
                        BOOKS -> stringResource(id = R.string.books)
                        MY -> stringResource(id = R.string.my)
                    },
                    icon = {
                        when (item) {
                            HOME -> {
                                HomeIcon(
                                    isSelected = currentDestination == item,
                                    modifier = modifier,
                                )
                            }

                            EVENT -> {
                                HeartIcon(
                                    isSelected = currentDestination == item,
                                    modifier = modifier,
                                )
                            }

                            BOOKS -> {
                                BookIcon(
                                    isSelected = currentDestination == item,
                                    modifier = modifier,
                                )
                            }

                            MY -> {
                                ProfileIcon(
                                    isSelected = currentDestination == item,
                                    modifier = modifier,
                                )
                            }
                        }
                    },
                    modifier = modifier
                        .then(
                            if (currentDestination == item) {
                                Modifier
                            } else {
                                Modifier.clickableSingle(onClick = { setCurrentDestination(item) })
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
    val topDestination by remember {
        mutableStateOf(HOME)
    }
    MindWayNavBar(
        currentDestination = topDestination,
        setCurrentDestination = { }
    )
}