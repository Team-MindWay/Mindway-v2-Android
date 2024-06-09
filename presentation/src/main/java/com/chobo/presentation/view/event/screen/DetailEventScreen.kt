package com.chobo.presentation.view.event.screen

import androidx.activity.ComponentActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.rememberImagePainter
import com.chobo.domain.model.event.response.GetDetailEventResponseModel
import com.chobo.presentation.R
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
        id = id,
        getDetailEventUiState = getDetailEventUiState,
        getDetailEvent = detailEventViewModel::getDetailEvent,
        navigateToBack = navigateToBack
    )
}

@Composable
internal fun DetailEventScreen(
    modifier: Modifier = Modifier,
    getDetailEventUiState: GetDetailEventUiState,
    id: Long,
    getDetailEvent: (Long) -> Unit,
    navigateToBack: () -> Unit,
) {
    LaunchedEffect(Unit) {
        getDetailEvent(id)
    }

    MindWayAndroidTheme { colors, _ ->
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
                    is GetDetailEventUiState.Fail -> Unit
                    is GetDetailEventUiState.Loading -> Unit
                    is GetDetailEventUiState.Success -> {
                        Image(
                            painter = rememberImagePainter(data = getDetailEventUiState.getDetailEventResponse.image),
                            contentDescription = "Event Image",
                            modifier = Modifier
                                .padding(vertical = 20.dp)
                                .fillMaxWidth()
                                .height(264.dp)
                                .clip(shape = RoundedCornerShape(8.dp))
                        )
                        DetailEventContent(
                            title = getDetailEventUiState.getDetailEventResponse.title,
                            content = getDetailEventUiState.getDetailEventResponse.content,
                            startedAt = getDetailEventUiState.getDetailEventResponse.startedAt,
                            endedAt = getDetailEventUiState.getDetailEventResponse.endedAt
                        )
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
        image = "https://example.com/image.jpg",
        title = "Sample Event",
        content = "This is a sample event description.",
        startedAt = "2024-01-01T00:00:00Z",
        endedAt = "2024-01-02T00:00:00Z"
    )
    DetailEventScreen(
        getDetailEventUiState = GetDetailEventUiState.Success(exampleEventResponse),
        getDetailEvent = {},
        navigateToBack = {},
        id = 0
    )
}