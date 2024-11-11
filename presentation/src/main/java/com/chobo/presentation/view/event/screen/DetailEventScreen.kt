package com.chobo.presentation.view.event.screen

import androidx.activity.ComponentActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import com.chobo.presentation.R
import com.chobo.presentation.view.component.icon.BookImage
import com.chobo.presentation.view.component.icon.ChevronLeftIcon
import com.chobo.presentation.view.component.modifier.multipleEventsCutterManager.clickableSingle
import com.chobo.presentation.view.component.shimmer.shimmerEffect
import com.chobo.presentation.view.component.topBar.MindWayTopAppBar
import com.chobo.presentation.view.event.component.DetailEventContent
import com.chobo.presentation.view.theme.MindWayAndroidTheme
import com.chobo.presentation.viewModel.event.DetailEventViewModel
import com.chobo.presentation.viewModel.event.uistate.GetDetailEventUiState

@Composable
internal fun DetailEventRoute(
    modifier: Modifier = Modifier,
    detailEventViewModel: DetailEventViewModel = hiltViewModel(LocalContext.current as ComponentActivity),
    id: Long,
    navigateToBack: () -> Unit,
) {
    val getDetailEventUiState by detailEventViewModel.getDetailEventUiState.collectAsStateWithLifecycle()

    DetailEventScreen(
        modifier = modifier,
        getDetailEventUiState = getDetailEventUiState,
        navigateToBack = navigateToBack
    )

    LaunchedEffect(Unit) {
        detailEventViewModel.getDetailEvent(id)
    }
}

@Composable
internal fun DetailEventScreen(
    modifier: Modifier = Modifier,
    getDetailEventUiState: GetDetailEventUiState,
    navigateToBack: () -> Unit,
) {
    MindWayAndroidTheme { colors, typography ->
        Column(
            modifier = modifier
                .background(color = colors.WHITE)
                .padding(horizontal = 24.dp)
        ) {
            MindWayTopAppBar(
                startIcon = { ChevronLeftIcon(modifier = Modifier.clickableSingle(onClick = navigateToBack)) },
                midText = stringResource(id = R.string.ongoing_event)
            )
            Column(modifier = Modifier.fillMaxSize()) {
                when (getDetailEventUiState) {
                    is GetDetailEventUiState.Fail -> {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            Column(
                                verticalArrangement = Arrangement.spacedBy(20.dp, Alignment.Top),
                                horizontalAlignment = Alignment.CenterHorizontally,
                            ) {
                                BookImage()
                                Text(
                                    text = stringResource(R.string.missing_data),
                                    style = typography.bodyMedium,
                                    fontWeight = FontWeight.Normal,
                                    color = colors.GRAY500,
                                )
                            }
                        }
                    }

                    is GetDetailEventUiState.Loading -> {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            Column(
                                verticalArrangement = Arrangement.spacedBy(20.dp, Alignment.Top),
                                horizontalAlignment = Alignment.CenterHorizontally,
                            ) {
                                BookImage()
                                Text(
                                    text = "로딩중 ..",
                                    style = typography.bodyMedium,
                                    fontWeight = FontWeight.Normal,
                                    color = colors.GRAY500,
                                )
                            }
                        }
                    }
                    is GetDetailEventUiState.Success -> {
                        val painter = rememberAsyncImagePainter(model = getDetailEventUiState.data.img_url)

                        Box(
                            modifier = Modifier
                                .padding(vertical = 20.dp)
                                .fillMaxWidth()
                                .height(264.dp)
                                .clip(shape = RoundedCornerShape(8.dp))
                        ) {
                            if (painter.state is AsyncImagePainter.State.Loading) {
                                Box(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .shimmerEffect(RoundedCornerShape(8.dp))
                                        .background(colors.GRAY300, RoundedCornerShape(8.dp))
                                )
                            } else {
                                Image(
                                    painter = painter,
                                    contentDescription = "Event Image",
                                    modifier = Modifier.fillMaxSize()
                                )
                            }
                        }

                        getDetailEventUiState.data.apply {
                            DetailEventContent(
                                title = title,
                                content = content,
                                startedAt = started_at,
                                endedAt = ended_at
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DetailEventScreenPre() {
    DetailEventScreen(
        getDetailEventUiState = GetDetailEventUiState.Fail,
        navigateToBack = {},
    )
}