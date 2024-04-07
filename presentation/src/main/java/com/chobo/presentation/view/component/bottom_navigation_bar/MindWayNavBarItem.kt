package com.chobo.presentation.view.component.bottom_navigation_bar

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.chobo.presentation.R
import com.chobo.presentation.view.component.icon.BookIcon
import com.chobo.presentation.view.component.icon.HeartIcon
import com.chobo.presentation.view.component.icon.HomeIcon
import com.chobo.presentation.view.component.icon.ProfileIcon
import com.chobo.presentation.view.theme.MindWayAndroidTheme

@Composable
fun MindWayNavBarItem(
    modifier: Modifier = Modifier,
    type: MindWayNavBarItemType,
    isPressed: Boolean
) {
    MindWayAndroidTheme { _, typography ->
        when(type) {
            MindWayNavBarItemType.HOME -> {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    HomeIcon(modifier = modifier, isSelected = isPressed)
                    Spacer(modifier = modifier.height(4.dp))
                    Text(
                        text = stringResource(id = R.string.home),
                        style = typography.labelLarge,
                        fontWeight = FontWeight.Normal,
                        fontSize = 14.sp
                    )
                }
            }
            MindWayNavBarItemType.EVENT -> {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    HeartIcon(modifier = modifier, isSelected = isPressed)
                    Spacer(modifier = modifier.height(4.dp))
                    Text(
                        text = stringResource(id = R.string.event),
                        style = typography.labelLarge,
                        fontWeight = FontWeight.Normal,
                        fontSize = 14.sp
                    )
                }
            }
            MindWayNavBarItemType.BOOKS -> {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    BookIcon(modifier = modifier, isSelected = isPressed)
                    Spacer(modifier = modifier.height(4.dp))
                    Text(
                        text = stringResource(id = R.string.books),
                        style = typography.labelLarge,
                        fontWeight = FontWeight.Normal,
                        fontSize = 14.sp
                    )
                }
            }
            MindWayNavBarItemType.MY -> {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    ProfileIcon(modifier = modifier, isSelected = isPressed)
                    Spacer(modifier = modifier.height(4.dp))
                    Text(
                        text = stringResource(id = R.string.my),
                        style = typography.labelLarge,
                        fontWeight = FontWeight.Normal,
                        fontSize = 14.sp
                    )
                }
            }
        }
    }
}