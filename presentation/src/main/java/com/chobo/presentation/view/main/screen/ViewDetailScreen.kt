package com.chobo.presentation.view.main.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.chobo.presentation.R
import com.chobo.presentation.view.component.bottom_sheet.MindWayBottomSheetDialog
import com.chobo.presentation.view.main.component.HomeBottomSheet
import com.chobo.presentation.view.main.component.ViewDetailPopUp
import com.chobo.presentation.view.main.component.ViewDetailTextCard
import com.chobo.presentation.view.main.component.ViewDetailTopAppBar
import com.chobo.presentation.view.theme.MindWayAndroidTheme
import com.chobo.presentation.viewModel.main.ViewDetailViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
internal fun ViewDetailRoute(
    modifier: Modifier = Modifier,
    viewDetailViewModel: ViewDetailViewModel = viewModel(),
    navigateToBack: () -> Unit,
    navigateToHomeEditBook: () -> Unit,
) {
    val titleTextState by viewDetailViewModel.titleTextState.collectAsStateWithLifecycle()
    val contentTextState by viewDetailViewModel.contentTextState.collectAsStateWithLifecycle()
    val checkBookDialogIsVisible by viewDetailViewModel.checkBookDialogIsVisible.collectAsStateWithLifecycle()
    val coroutineScope = rememberCoroutineScope()

    ViewDetailScreen(
        modifier = modifier,
        titleTextState = titleTextState,
        contentTextState = contentTextState,
        coroutineScope = coroutineScope,
        checkBookDialogIsVisible = checkBookDialogIsVisible,
        checkOnclick = viewDetailViewModel::checkOnclick,
        toggleCheckBookDialogIsVisible = viewDetailViewModel::toggleCheckBookDialogIsVisible,
        navigateToBack = navigateToBack,
        navigateToHomeEditBook = navigateToHomeEditBook,
    )
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
internal fun ViewDetailScreen(
    modifier: Modifier = Modifier,
    titleTextState: String,
    contentTextState: String,
    coroutineScope: CoroutineScope,
    checkBookDialogIsVisible: Boolean,
    checkOnclick: () -> Unit,
    toggleCheckBookDialogIsVisible: () -> Unit,
    navigateToBack: () -> Unit,
    navigateToHomeEditBook: () -> Unit,
) {
    MindWayAndroidTheme { colors, _ ->
        MindWayBottomSheetDialog(
            sheetContent = {
                HomeBottomSheet(
                    navigateToBookEdit = navigateToHomeEditBook,
                    bookDeleteOnClick = toggleCheckBookDialogIsVisible,
                )
            }
        ) { sheetState ->
            Column(
                modifier = modifier
                    .fillMaxSize()
                    .background(color = colors.WHITE)
            ) {
                if (checkBookDialogIsVisible) {
                    Dialog(onDismissRequest = toggleCheckBookDialogIsVisible) {
                        ViewDetailPopUp(
                            cancelOnclick = toggleCheckBookDialogIsVisible,
                            checkOnclick = {
                                checkOnclick()
                                toggleCheckBookDialogIsVisible()
                            },
                        )
                    }
                }
                ViewDetailTopAppBar(
                    startIconOnClick = navigateToBack,
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
    ViewDetailRoute(
        navigateToBack = { },
        navigateToHomeEditBook = { },
    )
}