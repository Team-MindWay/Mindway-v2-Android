package com.chobo.presentation.view.component.customToast

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chobo.presentation.view.component.icon.FailIcon
import com.chobo.presentation.view.component.icon.SuccessIcon
import com.chobo.presentation.view.theme.MindWayAndroidTheme

@Composable
fun MindWayToast(
    modifier: Modifier = Modifier,
    text: String,
    isSuccess: Boolean,
) {
    MindWayAndroidTheme { colors, typography ->
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.Start),
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .shadow(
                    elevation = 20.dp,
                    spotColor = colors.StatusShadow,
                    ambientColor = colors.StatusShadow
                )
                .background(
                    color = colors.WHITE,
                    shape = RoundedCornerShape(size = 8.dp)
                )
                .padding(
                    vertical = 20.dp,
                    horizontal = 16.dp
                )
        ) {
            if (isSuccess) SuccessIcon() else FailIcon()
            Text(
                text = text,
                style = typography.labelLarge,
                fontWeight = FontWeight.Normal,
                color = colors.Black,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Preview
@Composable
fun MindWayToastPreview() {
    MindWayToast(
        text = "토스트 메시지",
        isSuccess = false,
        modifier = Modifier
            .fillMaxWidth()
            .height(57.dp)
    )
}