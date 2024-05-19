package com.chobo.presentation.view.book.component

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chobo.presentation.view.component.multipleEventsCutterManager.clickableSingle
import com.chobo.presentation.view.theme.MindWayAndroidTheme

@Composable
fun BookTabRowItem(
    tabName: String,
    onClick: () -> Unit,
    isCurrentIndex: Boolean,
) {
    MindWayAndroidTheme { colors, typography ->
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(8.dp)
                .clickableSingle(onClick = onClick)
        ) {
            if (isCurrentIndex) {
                Text(
                    text = tabName,
                    style = typography.bodyLarge,
                    fontWeight = FontWeight.SemiBold,
                    color = colors.Black,
                )
            } else {
                Text(
                    text = tabName,
                    style = typography.bodyLarge,
                    fontWeight = FontWeight.Normal,
                    color = colors.GRAY400,
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BookTabRowItemPreview() {
    var indexState by remember { mutableIntStateOf(0) }
    BookTabRowItem(
        tabName = "이름",
        onClick = { indexState = 1 },
        isCurrentIndex = true
    )
}