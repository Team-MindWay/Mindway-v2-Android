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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.chobo.presentation.view.event.component.DetailEventContent
import com.chobo.presentation.view.event.component.DetailEventTopBar
import com.chobo.presentation.view.theme.MindWayAndroidTheme
import com.chobo.presentation.viewModel.DetailEventViewModel

@Composable
fun DetailEventScreen(
    modifier: Modifier = Modifier,
    detailEventViewModel: DetailEventViewModel = viewModel(),
    navigateToBack: () -> Unit,
) {
    MindWayAndroidTheme { _, _ ->
        Column {
            Spacer(modifier = modifier.height(20.dp))
            DetailEventTopBar(startIconOnClick = { navigateToBack() })
            Column(
                modifier = modifier
                    .fillMaxSize()
                    .padding(horizontal = 24.dp)
            ) {
                Image(
                    painter = painterResource(detailEventViewModel.returnImageResId()),
                    contentDescription = "Event Image",
                    modifier = modifier
                        .padding(vertical = 20.dp)
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
}

@Preview(showBackground = true)
@Composable
fun DetailEventScreenPre() {
    DetailEventScreen(navigateToBack = { })
}