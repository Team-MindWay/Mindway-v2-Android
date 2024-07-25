package com.chobo.presentation.view.main.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.chobo.presentation.R
import com.chobo.presentation.view.component.bottom_sheet.MindWayBottomSheet
import com.chobo.presentation.view.component.bottom_sheet.MindWayBottomSheetDialog
import com.chobo.presentation.view.component.icon.ChevronLeftIcon
import com.chobo.presentation.view.component.icon.OptionIcon
import com.chobo.presentation.view.component.multipleEventsCutterManager.clickableSingle
import com.chobo.presentation.view.component.topBar.MindWayTopAppBar
import com.chobo.presentation.view.main.component.ViewDetailPopUp
import com.chobo.presentation.view.main.component.ViewDetailTextCard
import com.chobo.presentation.view.theme.MindWayAndroidTheme
import com.chobo.presentation.viewModel.goal.uistate.GetBookByIdUiState
import com.chobo.presentation.viewModel.main.ViewDetailViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
internal fun ViewDetailRoute(
    modifier: Modifier = Modifier,
    viewDetailViewModel: ViewDetailViewModel = hiltViewModel(),
    id: Long,
    navigateToHomeEditBook: (Long) -> Unit,
    navigateToBack: () -> Unit,
) {
    val getBookByIdUiState by viewDetailViewModel.getBookByIdUiState.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewDetailViewModel.getBookById(id)
    }

    ViewDetailScreen(
        modifier = modifier,
        getBookByIdUiState = getBookByIdUiState,
        bookDeleteById = {
            viewDetailViewModel.bookDeleteById(id)
        },
        navigateToHomeEditBook = {
            navigateToHomeEditBook(id)
        },
        navigateToBack = navigateToBack,
    )
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
internal fun ViewDetailScreen(
    modifier: Modifier = Modifier,
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
    getBookByIdUiState: GetBookByIdUiState,
    bookDeleteById: () -> Unit,
    navigateToHomeEditBook: () -> Unit,
    navigateToBack: () -> Unit,
) {
    val (isDialogOpen, setIsDialogOpen) = remember { mutableStateOf(false) }
    val sheetState = rememberModalBottomSheetState(
        ModalBottomSheetValue.Hidden,
        skipHalfExpanded = true
    )

    MindWayAndroidTheme { colors, _ ->
        MindWayBottomSheetDialog(
            sheetContent = {
                MindWayBottomSheet(
                    topText = stringResource(R.string.book_modify),
                    bottomText = stringResource(R.string.book_delete),
                    topOnClick = { navigateToHomeEditBook() },
                    bottomOnClick = { setIsDialogOpen(true) },
                )
            },
            sheetState = sheetState
        ) {
            Column(
                modifier = modifier
                    .fillMaxSize()
                    .background(color = colors.WHITE)
            ) {
                if (isDialogOpen) {
                    Dialog(onDismissRequest = { setIsDialogOpen(false) }) {
                        ViewDetailPopUp(
                            cancelOnclick = { setIsDialogOpen(false) },
                            checkOnclick = {
                                setIsDialogOpen(false)
                                bookDeleteById()
                                navigateToBack()
                            },
                        )
                    }
                }
                MindWayTopAppBar(
                    startIcon = {
                        ChevronLeftIcon(modifier = Modifier.clickableSingle(onClick = navigateToBack))
                    },
                    endIcon = {
                        OptionIcon(modifier = Modifier.clickableSingle(onClick = { coroutineScope.launch { sheetState.show() } }))
                    },
                    midText = stringResource(R.string.view_detail),
                )
                when (getBookByIdUiState) {
                    is GetBookByIdUiState.Success -> {
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
                                content = getBookByIdUiState.data.title,
                            )
                            ViewDetailTextCard(
                                title = stringResource(R.string.content),
                                content = getBookByIdUiState.data.plot,
                            )
                        }
                    }

                    else -> Unit
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
        navigateToHomeEditBook = { },
        bookDeleteById = { },
        getBookByIdUiState = GetBookByIdUiState.Loading
    )
}