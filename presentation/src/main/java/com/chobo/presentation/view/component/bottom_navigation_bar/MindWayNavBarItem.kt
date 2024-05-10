package com.chobo.presentation.view.component.bottom_navigation_bar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.chobo.presentation.view.component.icon.HomeIcon
import com.chobo.presentation.view.theme.MindWayAndroidTheme

@Composable
fun MindWayNavBarItem(
    modifier: Modifier = Modifier,
    colors: Color,
    text: String,
    icon: @Composable () -> Unit
) {
    MindWayAndroidTheme { _, typography ->
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            icon()
            Spacer(modifier = modifier.height(4.dp))
            Text(
                text = text,
                style = typography.labelLarge,
                fontWeight = FontWeight.Medium,
                fontSize = 11.sp,
                color = colors
            )
        }
    }
}

@Preview
@Composable
fun MindWayNavBarItemPreview() {
    MindWayNavBarItem(
        text = "홈",
        colors = Color.Black,
        icon = { HomeIcon() }
    )
}