package com.chobo.presentation.view.book.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chobo.presentation.view.component.multipleEventsCutterManager.clickableSingle
import com.chobo.presentation.view.theme.MindWayAndroidTheme

@Composable
fun BookTabRowItem(
    indexState: Int,
    index: Int,
    tabName: String,
    onClick: () -> Unit,
) {
    MindWayAndroidTheme { colors, typography ->
        Row(
            horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterHorizontally),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(8.dp)
                .clickableSingle(onClick = onClick)
        ) {
            if (indexState == index) { // TODO: 상태 호이스팅
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
        indexState = 1,
        index = 1,
        tabName = "이름",
        onClick = { indexState = 1 }
    )
}