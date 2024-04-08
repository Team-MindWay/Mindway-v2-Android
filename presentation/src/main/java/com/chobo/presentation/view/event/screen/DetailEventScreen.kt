package com.chobo.presentation.view.event.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chobo.presentation.R
import com.chobo.presentation.view.event.component.DetailEventContent
import com.chobo.presentation.view.event.component.DetailEventTopBar
import com.chobo.presentation.view.theme.MindWayAndroidTheme

@Composable
fun DetailEventScreen(
    modifier: Modifier = Modifier
) {
    MindWayAndroidTheme { colors, _ ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .background(color = colors.WHITE)
                .padding(horizontal = 24.dp)
        ) {
            DetailEventTopBar(title = stringResource(id = R.string.ongoing_event))
            Spacer(modifier = modifier.height(20.dp))
            Image(
                painter = painterResource(id = R.drawable.mind_way_logo),
                contentDescription = "Event Image",
                modifier = modifier
                    .fillMaxWidth()
                    .height(264.dp)
                    .clip(shape = RoundedCornerShape(8.dp))
            )
            DetailEventContent(
                title = "가을 독서 행사",
                content = "독서의 계절, 가을을 맞아 도서관에서 특별한 이벤트를 준비했습니다. " +
                        "랜덤으로 초성 책 제목이 적혀있는 쪽지를 뽑고, 그에 맞는 책을 찾아오면 푸짐한 선물뽑기를 할 수 있습니다. " +
                        "점심시간마다 진행할 예정이니 많은 관심 바랍니다.",
                date = "2023년 06월 20일 ~ 2023년 07월 08일"
            )
        }
    }
}

@Preview
@Composable
fun DetailEventScreenPre() {
    DetailEventScreen()
}