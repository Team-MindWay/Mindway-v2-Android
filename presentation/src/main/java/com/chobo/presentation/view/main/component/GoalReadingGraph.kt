package com.chobo.presentation.view.main.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chobo.presentation.view.theme.MindWayAndroidTheme
import com.chobo.presentation.viewModel.util.ifZeroThenOne

@Stable
@Composable
fun GoalReadingGraph(
    modifier: Modifier = Modifier,
    numBooksRead: Int,
    maxBooksRead: Int,
    isCurrentDate: Boolean,
    today: String,
) {
    MindWayAndroidTheme { colors, typography ->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.Bottom),
            modifier = modifier,
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(0.dp, Alignment.Top),
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = numBooksRead.toString(),
                    style = typography.labelLarge,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Normal,
                    color = colors.GRAY800,
                )
                Spacer(
                    modifier = Modifier
                        .height(((27 * numBooksRead) / (maxBooksRead.ifZeroThenOne()) + 1).dp)
                        .fillMaxWidth()
                        .background(
                            color = if (!isCurrentDate) colors.GRAY200 else colors.MAIN,
                            shape = RoundedCornerShape(
                                topStart = 4.dp,
                                topEnd = 4.dp,
                            )
                        )
                )
            }
            Text(
                text = today,
                style = typography.labelLarge,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Normal,
                color = colors.GRAY800,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GoalReadingGraphPreview() {
    Box(modifier = Modifier.width(17.dp)) {
        GoalReadingGraph(numBooksRead = 2, maxBooksRead = 6, isCurrentDate = true, today = "일")
    }
}