package com.chobo.presentation.view.main.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chobo.domain.model.rank.RankModel
import com.chobo.presentation.view.theme.MindWayAndroidTheme

@Composable
fun HomeReadersOfTheMonthGraph(
    modifier: Modifier,
    rankModel: RankModel,
    maxBook: Int,
) {
    val height = ((78 * rankModel.accrue) / maxBook + 2).toFloat().dp
    MindWayAndroidTheme { colors, typography ->
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.Top),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
        ) {
            Text(
                text = "${rankModel.accrue}권",
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
                text = rankModel.name,
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
        modifier = Modifier.width(50.dp),
        maxBook = 35,
        rankModel = RankModel(
            name = "사람",
            accrue = 15
        )
    )
}