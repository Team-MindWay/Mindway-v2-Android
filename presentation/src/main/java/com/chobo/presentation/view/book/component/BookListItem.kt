package com.chobo.presentation.view.book.component

import android.graphics.Color
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
import com.chobo.domain.model.recommend.response.RecommendListResponseAllModel
import com.chobo.presentation.view.theme.MindWayAndroidTheme

@Composable
fun BookListItem(
    modifier: Modifier = Modifier,
    data: RecommendListResponseAllModel
) {
    MindWayAndroidTheme { colors, typography ->
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.Top),
            horizontalAlignment = Alignment.Start,
            modifier = modifier
                .fillMaxWidth()
                .shadow(
                    elevation = 20.dp,
                    spotColor = colors.CardShadow,
                )
                .background(
                    color = colors.WHITE,
                    shape = RoundedCornerShape(size = 8.dp)
                )
                .padding(all = 24.dp),
        ) {
            Column {
                Text(
                    text = data.title,
                    style = typography.bodyLarge,
                    fontWeight = FontWeight.SemiBold,
                    color = colors.Black,
                )
                Text(
                    text = data.content,
                    style = typography.bodySmall,
                    fontWeight = FontWeight.Normal,
                    color = colors.Black,
                )
            }
            Text(
                text = data.author,
                style = typography.labelLarge,
                fontWeight = FontWeight.Normal,
                color = colors.GRAY400,
            )
        }
    }
}

@Preview(
    showBackground = true,
    backgroundColor = Color.BLACK.toLong()
)
@Composable
fun BookListItemPreview() {
    BookListItem(
        data = RecommendListResponseAllModel(
            author = "저자",
            title = "제목",
            content = "ㅇㄴ머왲ㅂ옱ㄹ촣퍼ㅗㅠㅏㅓㅟㅡㅌㅇㄹㅎ촣퍼ㅗㅠㅏㅓㅟㅏㅡㅓㅜㅠㅏㅗ펗촗ㅌㅇㄹㅊㅎ퍼ㅗㅠㅓㅏㅜㅏㅣ"
        )
    )
}