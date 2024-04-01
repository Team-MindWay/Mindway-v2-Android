package com.chobo.presentation.view.main.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.font.FontWeight
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
                verticalArrangement = Arrangement.spacedBy(20.dp, Alignment.Top),
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = modifier
                    .shadow(
                        elevation = 20.dp,
                        spotColor = colors.WHITE,
                        ambientColor = colors.WHITE
                    )
                    .background(
                        color = colors.WHITE,
                        shape = RoundedCornerShape(size = 8.dp)
                    )
                    .padding(24.dp)
            ) {
                Text(
                    text = "이달의 독서왕",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(27.dp),
                    style = typography.bodyMedium,
                    fontWeight = FontWeight(600),
                    color = colors.Black,
                )
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.Bottom,
                    modifier = Modifier.fillMaxSize()
                ) {
                    bookKingOfTheMonthData.forEach {
                        HomeReadersOfTheMonthGraph(bookKingOfTheMonthData = it)
                    }
                }
            }
        } else {
            Column(
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .shadow(
                        elevation = 20.dp,
                        spotColor = colors.GRAY400,
                        ambientColor = colors.GRAY400
                    )
                    .fillMaxWidth()
                    .height(239.dp)
                    .background(color = colors.WHITE, shape = RoundedCornerShape(size = 8.dp))
                    .padding(start = 24.dp, top = 24.dp, end = 24.dp, bottom = 24.dp)
            ) {
                Text(
                    text = "이달의 독서왕",
                    style = typography.bodyMedium,
                    fontWeight = FontWeight(600),
                    color = colors.Black,
                )
                Text(
                    text = "아직 이달의 독서왕이 없습니다.",
                    style = typography.bodySmall,
                    fontWeight = FontWeight(400),
                    color = colors.GRAY400,
                )
                Spacer(modifier = Modifier.height(27.dp))
            }
        }
    }
}