package com.chobo.presentation.view.main.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
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
import com.chobo.domain.model.notice.NoticeAllModel
import com.chobo.presentation.R
import com.chobo.presentation.view.theme.MindWayAndroidTheme

@Stable
@Composable
fun HomeNoticeCard(
    modifier: Modifier = Modifier,
    noticeAllModel: NoticeAllModel,
) {
    MindWayAndroidTheme { colors, typography ->
        Row(
            horizontalArrangement = Arrangement.spacedBy(20.dp, Alignment.Start),
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .fillMaxWidth()
                .background(
                    color = colors.GRAY100,
                    shape = RoundedCornerShape(size = 8.dp)
                )
                .padding(horizontal = 12.dp)
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
                    modifier = modifier.padding(top = 18.5.dp),
                    text = noticeAllModel.title,
                    style = typography.bodyMedium,
                    fontWeight = FontWeight.SemiBold,
                    color = colors.Black,
                )
                Text(
                    modifier = modifier.padding(bottom = 18.5.dp),
                    text = noticeAllModel.content,
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
        noticeAllModel = NoticeAllModel(title = "제목제목제목제목", content = "내용")
    )
}