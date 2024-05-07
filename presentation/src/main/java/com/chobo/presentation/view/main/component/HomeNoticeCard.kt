package com.chobo.presentation.view.main.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.chobo.presentation.R
import com.chobo.presentation.view.component.multipleEventsCutterManager.clickableSingle
import com.chobo.presentation.view.theme.MindWayAndroidTheme

@Composable
fun HomeNoticeCard(
    modifier: Modifier = Modifier,
    titleText: String,
    content: String,
    onClick: () -> Unit,
) {
    MindWayAndroidTheme { colors, typography ->
        Row(
            horizontalArrangement = Arrangement.spacedBy(20.dp, Alignment.Start),
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .clickableSingle { onClick() }
                .background(
                    color = colors.GRAY100,
                    shape = RoundedCornerShape(size = 8.dp)
                )
                .padding(horizontal = 12.dp,)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic__notice),
                contentDescription = "image description",
                contentScale = ContentScale.None,
            )
            Column(
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.Start,
            ) {
                Text(
                    text = titleText,
                    style = typography.bodyMedium,
                    fontWeight = FontWeight.SemiBold,
                    color = colors.Black,
                )
                Text(
                    text = content,
                    style = TextStyle(
                        fontSize = 12.sp,
                        lineHeight = 18.sp,
                        fontFamily = FontFamily(Font(R.font.pretendard)),
                        fontWeight = FontWeight.Normal,
                        color = colors.Black,
                    )
                )
            }
        }
    }
}

@Preview
@Composable
fun HomeNoticeCardPreview() {
    HomeNoticeCard(
        titleText = "제못 텍스트",
        content = "정말 엄청난 알림",
        modifier = Modifier
            .width(312.dp)
            .height(100.dp),
        onClick = {  }
    )
}