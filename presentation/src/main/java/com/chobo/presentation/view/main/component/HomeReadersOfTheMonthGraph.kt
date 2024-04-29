package com.chobo.presentation.view.main.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chobo.presentation.view.theme.MindWayAndroidTheme

@Composable
fun HomeReadersOfTheMonthGraph(
    modifier: Modifier,
    bookKingOfTheMonthData: BookKingOfTheMonthData,
) {
    val height = ((78 * bookKingOfTheMonthData.numOfBooks) / 30 + 2).toFloat().dp
    MindWayAndroidTheme { colors, typography ->
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.Top),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
        ) {
            Text(
                text = "${bookKingOfTheMonthData.numOfBooks}권",
                style = typography.bodySmall,
                fontWeight = FontWeight.SemiBold,
                color = colors.GRAY800,
                textAlign = TextAlign.Center,
            )
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(height.value.dp)
                    .background(
                        color = colors.MAIN,
                        shape = RoundedCornerShape(
                            topStart = 8.dp,
                            topEnd = 8.dp,
                        )
                    )
            )
            Text(
                text = bookKingOfTheMonthData.name,
                style = typography.bodySmall,
                fontWeight = FontWeight.SemiBold,
                color = colors.GRAY800,
                textAlign = TextAlign.Center,
            )
        }
    }
}

@Preview
@Composable
fun HomeReadersOfTheMonthGraphPreview() {
    HomeReadersOfTheMonthGraph(
        bookKingOfTheMonthData = BookKingOfTheMonthData(
            name = "이름",
            numOfBooks = 12
        ),
        modifier = Modifier.width(50.dp)
    )
}