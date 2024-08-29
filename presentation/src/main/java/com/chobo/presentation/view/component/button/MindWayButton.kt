package com.chobo.presentation.view.component.button

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chobo.presentation.view.component.modifier.multipleEventsCutterManager.clickableSingle
import com.chobo.presentation.view.theme.MindWayAndroidTheme
import com.chobo.presentation.view.theme.color.MindWayColor

@Stable
@Composable
fun MindWayButton(
    modifier: Modifier = Modifier,
    text: String,
    buttonColor: Color = MindWayColor.MAIN,
    onClick: () -> Unit,
) {
    MindWayAndroidTheme { colors, typography ->
        Row(
            horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterHorizontally),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .background(
                    color = buttonColor,
                    shape = RoundedCornerShape(size = 8.dp)
                )
                .clickableSingle(onClick = onClick)
                .then(modifier)
        ) {
            Text(
                text = text,
                style = typography.bodyLarge,
                fontWeight = FontWeight.SemiBold,
                color = colors.WHITE,
                textAlign = TextAlign.Center,
            )
        }
    }
}

@Preview
@Composable
fun MindWayButtonPreview() {
    MindWayButton(
        modifier = Modifier.padding(10.dp),
        text = "이것은 택스트 입니다",
    ) {}
}