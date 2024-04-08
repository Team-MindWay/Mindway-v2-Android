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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.chobo.presentation.R
import com.chobo.presentation.view.event.component.DetailEventContent
import com.chobo.presentation.view.event.component.DetailEventTopBar
import com.chobo.presentation.view.theme.MindWayAndroidTheme
import com.chobo.presentation.viewModel.DetailEventViewModel

@Composable
fun DetailEventScreen(
    modifier: Modifier = Modifier,
    detailEventViewModel: DetailEventViewModel = viewModel(),
    navigateToEvent: () -> Unit,
) {
    MindWayAndroidTheme { colors, _ ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .background(color = colors.WHITE)
                .padding(horizontal = 24.dp)
        ) {
            DetailEventTopBar(
                title = stringResource(id = R.string.ongoing_event),
                navigateToEvent = navigateToEvent
            )
            Spacer(modifier = modifier.height(20.dp))
            Image(
                painter = painterResource(detailEventViewModel.returnImageResId()),
                contentDescription = "Event Image",
                modifier = modifier
                    .fillMaxWidth()
                    .height(264.dp)
                    .clip(shape = RoundedCornerShape(8.dp))
            )
            DetailEventContent(
                title = detailEventViewModel.returnTitle(),
                content = detailEventViewModel.returnContent(),
                date = detailEventViewModel.returnDate()
            )
        }
    }
}

@Preview
@Composable
fun DetailEventScreenPre() {
    DetailEventScreen(
        navigateToEvent = { }
    )
}