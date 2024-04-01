package com.chobo.presentation.view.main.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.chobo.presentation.view.theme.MindWayAndroidTheme

@Composable
fun HomeGoalReadingIndicator(
    modifier: Modifier = Modifier,
    numBooksRead: Int,
) {
    val readProgress = if (numBooksRead < 30) numBooksRead else 30
    MindWayAndroidTheme { colors, typography ->
        Row(
            modifier = modifier,
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            LinearProgressIndicator(
                progress = (readProgress) / 30f,
                modifier = Modifier
                    .padding(1.dp)
                    .fillMaxWidth(0.7576f)
                    .fillMaxHeight(0.33f)
                    .clip(RoundedCornerShape(5.dp)),
                trackColor = colors.GRAY100,
                color = colors.MAIN
            )
            Row(
                modifier = Modifier
                    .fillMaxHeight(),
                horizontalArrangement = Arrangement.spacedBy(4.dp, Alignment.CenterHorizontally),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = numBooksRead.toString(),
                    style = typography.bodyLarge,
                    fontWeight = FontWeight(600),
                    color = colors.Black,
                    textAlign = TextAlign.Center,
                )
                Row(
                    modifier = Modifier
                        .height(30.dp),
                    horizontalArrangement = Arrangement.spacedBy(
                        2.dp,
                        Alignment.CenterHorizontally
                    ),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(
                        text = "/",
                        style = typography.bodyLarge,
                        fontWeight = FontWeight(400),
                        color = colors.GRAY300,
                        textAlign = TextAlign.Center,
                    )
                    Text(
                        text = "30",
                        style = typography.bodySmall,
                        fontWeight = FontWeight(400),
                        color = colors.MAIN,
                        textAlign = TextAlign.Center,
                    )
                }
            }
        }
    }
}
