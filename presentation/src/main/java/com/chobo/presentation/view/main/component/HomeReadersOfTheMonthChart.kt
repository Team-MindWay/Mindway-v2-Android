package com.chobo.presentation.view.main.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chobo.presentation.view.theme.MindWayAndroidTheme

data class BookKingOfTheMonthData(val name: String, val numOfBooks: Int)

@Composable
fun HomeReadersOfTheMonthChart(
    modifier: Modifier = Modifier,
    isHasData: Boolean,
    bookKingOfTheMonthData: List<BookKingOfTheMonthData>
) {
    MindWayAndroidTheme { colors, typography ->
        if (isHasData) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(20.dp, Alignment.Top),
                modifier = modifier
                    .shadow(
                        elevation = 20.dp,
                        spotColor = colors.CardShadow,
                        ambientColor = colors.CardShadow,
                    )
                    .background(
                        color = colors.WHITE,
                        shape = RoundedCornerShape(size = 8.dp)
                    )
                    .padding(all = 24.dp)
            ) {
                Text(
                    text = "이달의 독서왕",
                    style = typography.bodyMedium,
                    fontWeight = FontWeight.SemiBold,
                    color = colors.Black,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(27.dp),
                )
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.Bottom,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    bookKingOfTheMonthData.forEachIndexed { index, it ->
                        HomeReadersOfTheMonthGraph(
                            bookKingOfTheMonthData = it,
                            modifier = Modifier.weight(72f)
                        )

                        if (index < bookKingOfTheMonthData.size - 1) {
                            Spacer(modifier = Modifier.fillMaxWidth(0.1666f))
                        }
                    }
                }
            }
        } else {
            Column(
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = modifier
                    .shadow(
                        elevation = 20.dp,
                        spotColor = colors.CardShadow,
                        ambientColor = colors.CardShadow,
                    )
                    .background(
                        color = colors.WHITE,
                        shape = RoundedCornerShape(size = 8.dp)
                    )
                    .padding(all = 24.dp)
            ) {
                Text(
                    text = "이달의 독서왕",
                    style = typography.bodyMedium,
                    fontWeight = FontWeight.SemiBold,
                    color = colors.Black,
                    modifier = Modifier.fillMaxWidth()
                )
                Text(
                    text = "아직 이달의 독서왕이 없습니다.",
                    style = typography.bodySmall,
                    fontWeight = FontWeight.Normal,
                    color = colors.GRAY400,
                )
                Spacer(modifier = Modifier.height(27.dp))
            }
        }
    }
}

@Preview
@Composable
fun HomeReadersOfTheMonthChartPreview() {
    HomeReadersOfTheMonthChart(
        isHasData = true,
        modifier = Modifier
            .width(312.dp),
        bookKingOfTheMonthData = listOf(
            BookKingOfTheMonthData("나다", 12),
            BookKingOfTheMonthData("나다", 2),
            BookKingOfTheMonthData("나다", 30),
        )
    )
}