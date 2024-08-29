package com.chobo.presentation.view.event.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chobo.presentation.R
import com.chobo.presentation.view.theme.MindWayAndroidTheme
import com.chobo.presentation.viewModel.util.formatServerDate

@Stable
@Composable
fun DetailEventContent(
    modifier: Modifier = Modifier,
    title: String,
    content: String,
    startedAt: String,
    endedAt: String
) {
    MindWayAndroidTheme { colors, typography ->
        Column(
            modifier = modifier
                .background(color = colors.WHITE)
                .fillMaxWidth(),
        ) {
            Text(
                text = title,
                style = typography.bodyLarge,
                color = colors.Black,
                fontWeight = FontWeight.SemiBold
            )
            Spacer(modifier = Modifier.padding(top = 10.dp))
            Text(
                text = content,
                style = typography.bodySmall,
                color = colors.Black,
                fontWeight = FontWeight.Normal
            )
            Spacer(modifier = Modifier.padding(14.dp))
            Text(
                text = stringResource(
                    R.string.wave,
                    startedAt.formatServerDate(),
                    endedAt.formatServerDate()
                ),
                style = typography.labelLarge,
                color = colors.GRAY400,
                fontWeight = FontWeight.Normal,
            )
        }
    }
}

@Preview
@Composable
fun DetailEventContentPre() {
    DetailEventContent(
        title = "가을 독서 행사",
        content = "독서의 계절, 가을을 맞아 도서관에서 특별한 이벤트를 준비했습니다. " +
                "랜덤으로 초성 책 제목이 적혀있는 쪽지를 뽑고, 그에 맞는 책을 찾아오면 푸짐한 선물뽑기를 할 수 있습니다. " +
                "점심시간마다 진행할 예정이니 많은 관심 바랍니다.",
        startedAt = "2023년 06월 20일",
        endedAt = "2023년 07월 08일"
    )
}