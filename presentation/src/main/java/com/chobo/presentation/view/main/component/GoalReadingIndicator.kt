package com.chobo.presentation.view.main.component

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chobo.presentation.view.theme.MindWayAndroidTheme

@Composable
fun GoalReadingIndicator(
    modifier: Modifier = Modifier,
    numBooksRead: Int,
    goalBookRead:Int
) {
    val readProgress = if (numBooksRead < 30) numBooksRead else 30
    MindWayAndroidTheme { colors, typography ->
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier,
        ) {
            LinearProgressIndicator(
                progress = (readProgress) / goalBookRead.toFloat(),
                trackColor = colors.GRAY100,
                color = colors.MAIN,
                modifier = Modifier
                    .padding(1.dp)
                    .fillMaxWidth(0.7576f)
                    .fillMaxHeight(0.33f)
                    .clip(RoundedCornerShape(5.dp)),
            )
            Row(
                modifier = Modifier.fillMaxHeight(),
                horizontalArrangement = Arrangement.spacedBy(4.dp, Alignment.CenterHorizontally),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = numBooksRead.toString(),
                    style = typography.bodyLarge,
                    fontWeight = FontWeight.SemiBold,
                    color = colors.Black,
                    textAlign = TextAlign.Center,
                )
                Row(
                    modifier = Modifier.height(30.dp),
                    horizontalArrangement = Arrangement.spacedBy(2.dp, Alignment.CenterHorizontally),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(
                        text = "/",
                        style = typography.bodyLarge,
                        fontWeight = FontWeight.Normal,
                        color = colors.GRAY300,
                        textAlign = TextAlign.Center,
                    )
                    Text(
                        text = goalBookRead.toString(),
                        style = typography.bodySmall,
                        fontWeight = FontWeight.Normal,
                        color = colors.MAIN,
                        textAlign = TextAlign.Center,
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun GoalReadingIndicatorPreview() {
    GoalReadingIndicator(
        numBooksRead = 12,
        modifier = Modifier
            .width(264.dp)
            .height(30.dp),
        goalBookRead = 20
    )
}