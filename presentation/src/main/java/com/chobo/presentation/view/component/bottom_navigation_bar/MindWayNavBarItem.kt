package com.chobo.presentation.view.component.bottom_navigation_bar

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
import androidx.compose.ui.tooling.preview.Preview
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
    isSelected: Boolean
) {
    val text =
        when (type) {
            MindWayNavBarItemType.HOME -> stringResource(id = R.string.home)
            MindWayNavBarItemType.EVENT -> stringResource(id = R.string.event)
            MindWayNavBarItemType.BOOKS -> stringResource(id = R.string.books)
            MindWayNavBarItemType.MY -> stringResource(id = R.string.my)
        }
    MindWayAndroidTheme { colors, typography ->
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            when (type) {
                MindWayNavBarItemType.HOME -> HomeIcon(modifier = modifier, isSelected = isSelected)
                MindWayNavBarItemType.EVENT -> HeartIcon(modifier = modifier, isSelected = isSelected)
                MindWayNavBarItemType.BOOKS -> BookIcon(modifier = modifier, isSelected = isSelected)
                MindWayNavBarItemType.MY -> ProfileIcon(modifier = modifier, isSelected = isSelected)
            }
            Spacer(modifier = modifier.height(4.dp))
            Text(
                text = text,
                style = typography.labelLarge,
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp,
                color = if (isSelected) colors.Black else colors.GRAY400
            )
        }
    }
}

@Preview
@Composable
fun MindWayNavBarItemPreview() {
    MindWayNavBarItem(
        type = MindWayNavBarItemType.HOME,
        isSelected = true
    )
}