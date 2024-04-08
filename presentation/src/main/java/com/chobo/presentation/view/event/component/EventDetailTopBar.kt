package com.chobo.presentation.view.event.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chobo.presentation.view.component.icon.ChevronLeftIcon
import com.chobo.presentation.view.theme.MindWayAndroidTheme

@Composable
fun EventDetailTopBar(
    modifier: Modifier = Modifier,
    title: String
) {
    MindWayAndroidTheme { colors, typography ->
        Row(
            modifier = modifier
                .fillMaxWidth()
                .background(color = colors.WHITE)
                .padding(
                    top = 20.dp,
                    bottom = 4.dp
                )
        ) {
            ChevronLeftIcon()
            Spacer(modifier = modifier.weight(1f))
            Text(
                text = title,
                style = typography.bodyMedium,
                color = colors.Black,
                fontWeight = FontWeight.SemiBold
            )
            Spacer(modifier = modifier.weight(1f))
            Spacer(
                modifier = modifier
                    .width(24.dp)
                    .height(24.dp)
            )
        }
    }
}

@Preview
@Composable
fun EventDetailTopBarPre() {
    EventDetailTopBar(
        title = "진행 중인 이벤트"
    )
}