package com.chobo.presentation.view.component.topBar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.chobo.presentation.view.theme.MindWayAndroidTheme

@Composable
fun MindWayOnlyStartTopAppBar(
    modifier: Modifier = Modifier,
    startIcon: @Composable () -> Unit = { MindWaySpacer(modifier = Modifier) },
    midText: String = "",
) {
    MindWayAndroidTheme { colors, typography ->
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Top,
            modifier = modifier
                .fillMaxWidth()
                .height(59.dp)
                .padding(
                    top = 20.dp,
                    bottom = 12.dp
                )
        ) {
            startIcon()
            Text(
                text = midText,
                style = typography.bodyMedium,
                fontWeight = FontWeight.SemiBold,
                color = colors.Black,
            ) 
            Spacer(
                modifier = modifier
                    .width(24.dp)
                    .height(24.dp)
            )
        }
    }
}