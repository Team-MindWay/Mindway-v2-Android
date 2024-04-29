package com.chobo.presentation.view.main.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.lifecycle.viewmodel.compose.viewModel
import com.chobo.presentation.R
import com.chobo.presentation.view.component.bottom_sheet.MindWayBottomSheetDialog
import com.chobo.presentation.view.main.component.HomeBottomSheet
import com.chobo.presentation.view.main.component.ViewDetailPopUp
import com.chobo.presentation.view.main.component.ViewDetailTextCard
import com.chobo.presentation.view.main.component.ViewDetailTopAppBar
import com.chobo.presentation.view.theme.MindWayAndroidTheme
import com.chobo.presentation.viewModel.ViewDetailViewModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ViewDetailScreen(
    modifier: Modifier = Modifier,
    viewDetailViewModel: ViewDetailViewModel = viewModel(),
    navigateToBack: () -> Unit,
    navigateToHomeEditBook: () -> Unit,
) {
    val titleTextState by viewDetailViewModel.titleTextState.collectAsState()
    val contentTextState by viewDetailViewModel.contentTextState.collectAsState()
    val coroutineScope = rememberCoroutineScope()
    var checkBookDialog by remember { mutableStateOf(false) }

    MindWayAndroidTheme { colors, _ ->
        MindWayBottomSheetDialog(
            sheetContent = {
                HomeBottomSheet(
                    navigateToBookEdit = navigateToHomeEditBook,
                    bookDeleteOnClick = { checkBookDialog = true },
                )
            }
        ) { sheetState ->
            Column(
                modifier = modifier
                    .fillMaxSize()
                    .background(color = colors.WHITE)
            ) {
                if (checkBookDialog) {
                    Dialog(onDismissRequest = { checkBookDialog = false }) {
                        ViewDetailPopUp(
                            cancelOnclick = {
                                viewDetailViewModel.cancelOnclick()
                                checkBookDialog = false
                            },
                            checkOnclick = {
                                viewDetailViewModel.checkOnclick()
                                checkBookDialog = false
                            },
                        )
                    }
                }
                Spacer(modifier = Modifier.height(20.dp))
                ViewDetailTopAppBar(
                    startIconOnClick = { navigateToBack() },
                    endIconOnClick = {
                        coroutineScope.launch { sheetState.show() }
                    }
                )
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
}

@Preview(showBackground = true)
@Composable
fun ViewDetailScreenPreview() {
    ViewDetailScreen(
        navigateToBack = { },
        navigateToHomeEditBook = { }
    )
}