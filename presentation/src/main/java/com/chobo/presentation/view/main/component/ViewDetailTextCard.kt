package com.chobo.presentation.view.main.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chobo.presentation.view.theme.MindWayAndroidTheme

@Composable
fun ViewDetailTextCard(
    title: String,
    content: String,
) {
    MindWayAndroidTheme { colors, typography ->
        Column(
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.spacedBy(
                4.dp,
                Alignment.Top
            ),
        ) {
            Text(
                text = title,
                style = typography.labelLarge,
                fontWeight = FontWeight.Normal,
                color = colors.GRAY400,
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(
                    10.dp,
                    Alignment.Start
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = colors.GRAY100,
                        shape = RoundedCornerShape(size = 8.dp)
                    )
                    .padding(all = 16.dp)
            ) {
                Text(
                    text = content,
                    style = typography.bodySmall,
                    fontWeight = FontWeight.Normal,
                    color = colors.Black,
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ViewDetailTextCard(
) {
    ViewDetailTextCard(title = "제목", content = " 가나다라마바사아자차카타파하 가나다라마바사아자차카타파하 가나다라마바사아자차카타파하 가나다라마바사아자차카타파하 가나다라마바사아자차카타파하 가나다라마바사아자차카타파하 가나다라마바사아자차카타파하 가나다라마바사아자차카타파하 가나다라마바사아자차카타파하 가나다라마바사아자차카타파하 가나다라마바사아자차카타파하")
}