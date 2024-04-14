package com.chobo.presentation.view.book.component

import android.widget.Space
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chobo.presentation.view.theme.MindWayAndroidTheme

data class BookListItemData(
    val writer: String,
    val title: String,
    val content: String,
)

@Composable
fun BookListItem(data: BookListItemData) {
    MindWayAndroidTheme { colors, typography ->
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.Top),
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
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
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = data.title,
                    style = typography.bodyLarge,
                    fontWeight = FontWeight.SemiBold,
                    color = colors.Black,
                )
                Text(
                    text = data.writer,
                    style = typography.labelLarge,
                    fontWeight = FontWeight.Normal,
                    color = colors.GRAY400,
                )
            }
            Text(
                text = data.content,
                style = typography.bodySmall,
                fontWeight = FontWeight.Normal,
                color = colors.Black,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BookListItemPreview() {
    BookListItem(
        data = BookListItemData(
            writer = "저자",
            title = "제목",
            content = "ㅇㄴ머왲ㅂ옱ㄹ촣퍼ㅗㅠㅏㅓㅟㅡㅌㅇㄹㅎ촣퍼ㅗㅠㅏㅓㅟㅏㅡㅓㅜㅠㅏㅗ펗촗ㅌㅇㄹㅊㅎ퍼ㅗㅠㅓㅏㅜㅏㅣ"
        )
    )
}