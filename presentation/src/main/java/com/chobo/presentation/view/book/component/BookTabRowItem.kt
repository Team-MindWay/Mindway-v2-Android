package com.chobo.presentation.view.book.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
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
fun BookTabRowItem(
    modifier: Modifier = Modifier,
    tabName: String,
    onClick: () -> Unit,
    isCurrentIndex: Boolean,
) {
    MindWayAndroidTheme { colors, typography ->
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
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
    BookTabRowItem(
        tabName = "이름",
        onClick = { },
        isCurrentIndex = true
    )
}