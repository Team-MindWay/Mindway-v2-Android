package com.chobo.presentation.view.main.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chobo.domain.model.rank.RankModel
import com.chobo.presentation.view.theme.MindWayAndroidTheme

@Stable
@Composable
fun HomeReadersOfTheMonthChart(
    modifier: Modifier = Modifier,
    isHasData: Boolean,
    bookKingOfTheMonthData: List<RankModel> = listOf()
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
                    val maxBook = bookKingOfTheMonthData.maxOf { it.accrue }
                    bookKingOfTheMonthData.forEachIndexed { index, it ->
                        HomeReadersOfTheMonthGraph(
                            rankModel = it,
                            maxBook = maxBook,
                            modifier = Modifier.weight(72f)
                        )
                        if (index < bookKingOfTheMonthData.size - 1) {
                            Spacer(modifier = Modifier.fillMaxWidth(0.1666f))
                        }

                    }
                    for (i in 1..3 - bookKingOfTheMonthData.size) {
                        Spacer(modifier = Modifier.fillMaxWidth(0.1666f))
                        HomeReadersOfTheMonthGraph(
                            rankModel = RankModel(name = "", accrue = 0),
                            maxBook = maxBook,
                            modifier = Modifier.weight(72f)
                        )
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
            RankModel("나다", 12),
            RankModel("나다", 12),
        )
    )
}