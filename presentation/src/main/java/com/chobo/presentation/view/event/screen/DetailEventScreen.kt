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
import coil.compose.rememberAsyncImagePainter
import com.chobo.domain.model.event.response.GetDetailEventResponseModel
import com.chobo.presentation.R
import com.chobo.presentation.view.component.icon.BookImage
import com.chobo.presentation.view.component.icon.ChevronLeftIcon
import com.chobo.presentation.view.component.multipleEventsCutterManager.clickableSingle
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
        Column(modifier = modifier.background(color = colors.WHITE)) {
            MindWayTopAppBar(
                startIcon = { ChevronLeftIcon(modifier = Modifier.clickableSingle(onClick = navigateToBack)) },
                midText = stringResource(id = R.string.ongoing_event)
            )
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 24.dp)
            ) {
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

                    is GetDetailEventUiState.Loading -> Unit
                    is GetDetailEventUiState.Success -> {
                        getDetailEventUiState.data.apply {
                            Image(
                                painter = rememberAsyncImagePainter(model = img_url),
                                contentDescription = "Event Image",
                                modifier = Modifier
                                    .padding(vertical = 20.dp)
                                    .fillMaxWidth()
                                    .height(264.dp)
                                    .clip(shape = RoundedCornerShape(8.dp))
                            )
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
    val exampleEventResponse = GetDetailEventResponseModel(
        img_url = "https://example.com/image.jpg",
        title = "Sample Event",
        content = "This is a sample event description.",
        started_at = "2024-01-01T00:00:00Z",
        ended_at = "2024-01-02T00:00:00Z"
    )
    DetailEventScreen(
        getDetailEventUiState = GetDetailEventUiState.Success(exampleEventResponse),
        navigateToBack = {},
    )
}