package com.chobo.presentation.view.component.bottom_sheet

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chobo.presentation.view.component.multipleEventsCutterManager.clickableSingle
import com.chobo.presentation.view.theme.MindWayAndroidTheme

@Composable
fun MindWayBottomSheet(
    topText: String,
    bottomText: String,
    topOnClick: () -> Unit,
    bottomOnCLick: () -> Unit,
) {
    MindWayAndroidTheme { colors, typography ->
        Column(
            verticalArrangement = Arrangement.spacedBy(20.dp, Alignment.Top),
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = colors.WHITE,
                    shape = RoundedCornerShape(
                        topStart = 12.dp,
                        topEnd = 12.dp,
                    )
                )
                .padding(
                    start = 24.dp,
                    top = 28.dp,
                    end = 24.dp,
                    bottom = 48.dp
                )
        ) {
            Text(
                text = topText,
                style = typography.bodySmall,
                fontWeight = FontWeight.Normal,
                color = colors.Black,
                modifier = Modifier.clickableSingle(onClick = topOnClick)
            )
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(1.dp)
                    .background(color = colors.GRAY100)
            )
            Text(
                text = bottomText,
                style = typography.bodySmall,
                fontWeight = FontWeight.Normal,
                color = colors.SYSTEM,
                modifier = Modifier.clickableSingle(onClick = bottomOnCLick)
            )
        }
    }
}

@Preview
@Composable
fun MindWayBottomSheetPreview() {
    MindWayBottomSheet(
        topText = "탑 텍스트",
        bottomText = "엔드 텍스트?",
        topOnClick = { },
        bottomOnCLick = { })
}