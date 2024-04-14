package com.chobo.presentation.view.main.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.chobo.presentation.R
import com.chobo.presentation.view.main.component.ViewDetailTextCard
import com.chobo.presentation.view.main.component.ViewDetailTopAppBar
import com.chobo.presentation.view.theme.MindWayAndroidTheme
import com.chobo.presentation.viewModel.ViewDetailViewModel

@Composable
fun ViewDetailScreen(
    modifier: Modifier = Modifier,
    viewDetailViewModel: ViewDetailViewModel = viewModel(),
    navigateToBack: () -> Unit
) {
    val titleTextState by viewDetailViewModel.titleTextState.collectAsState()
    val contentTextState by viewDetailViewModel.contentTextState.collectAsState()

    MindWayAndroidTheme { colors, typography ->
        Column(modifier = modifier
            .fillMaxSize()
            .background(color = colors.WHITE)
        ) {
            Spacer(modifier = Modifier.height(20.dp))
            ViewDetailTopAppBar(startIconOnClick = { navigateToBack() })
            Column(
                verticalArrangement = Arrangement.spacedBy(20.dp, Alignment.Top),
                horizontalAlignment = Alignment.Start,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        vertical = 24.dp,
                        horizontal = 28.dp,
                    )
            ) {
                ViewDetailTextCard(
                    title = stringResource(R.string.title),
                    content = titleTextState,
                )
                ViewDetailTextCard(
                    title = stringResource(R.string.content),
                    content = contentTextState,
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ViewDetailScreenPreview() {
    ViewDetailScreen(navigateToBack = { })
}