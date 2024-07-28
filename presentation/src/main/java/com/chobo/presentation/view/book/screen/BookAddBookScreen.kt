package com.chobo.presentation.view.book.screen

import androidx.activity.ComponentActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.chobo.presentation.R
import com.chobo.presentation.view.book.component.BookPopUp
import com.chobo.presentation.view.component.button.MindWayButton
import com.chobo.presentation.view.component.icon.ChevronLeftIcon
import com.chobo.presentation.view.component.multipleEventsCutterManager.clickableSingle
import com.chobo.presentation.view.component.textField.MindWayTextFieldNoneLimit
import com.chobo.presentation.view.component.topBar.MindWayTopAppBar
import com.chobo.presentation.view.theme.MindWayAndroidTheme
import com.chobo.presentation.viewModel.book.BookAddBookViewModel

@Composable
internal fun BookAddBookRoute(
    modifier: Modifier = Modifier,
    bookAddBookViewModel: BookAddBookViewModel = hiltViewModel(LocalContext.current as ComponentActivity),
    navigateToBack: () -> Unit,
) {
    val titleTextState by bookAddBookViewModel.titleTextState.collectAsStateWithLifecycle()
    val writeTextState by bookAddBookViewModel.writeTextState.collectAsStateWithLifecycle()
    val linkTextState by bookAddBookViewModel.linkTextState.collectAsStateWithLifecycle()
    val titleTextStateIsEmpty by bookAddBookViewModel.titleTextStateIsEmpty.collectAsStateWithLifecycle()
    val writeTextStateIsEmpty by bookAddBookViewModel.writeTextStateIsEmpty.collectAsStateWithLifecycle()
    val linkTextStateIsEmpty by bookAddBookViewModel.linkTextStateIsEmpty.collectAsStateWithLifecycle()

    BookAddBookScreen(
        modifier = modifier,
        titleTextState = titleTextState,
        writeTextState = writeTextState,
        linkTextState = linkTextState,
        titleTextStateIsEmpty = titleTextStateIsEmpty,
        writeTextStateIsEmpty = writeTextStateIsEmpty,
        linkTextStateIsEmpty = linkTextStateIsEmpty,
        updateTitleTextState = bookAddBookViewModel::updateTitleTextState,
        updateWriteTextState = bookAddBookViewModel::updateWriteTextState,
        updateLinkTextState = bookAddBookViewModel::updateLinkTextState,
        checkButtonOnClick = bookAddBookViewModel::checkButtonOnClick,
        navigateToBack = navigateToBack,
    )
}

@Composable
internal fun BookAddBookScreen(
    modifier: Modifier = Modifier,
    titleTextState: String,
    writeTextState: String,
    linkTextState: String,
    titleTextStateIsEmpty: Boolean,
    writeTextStateIsEmpty: Boolean,
    linkTextStateIsEmpty: Boolean,
    updateTitleTextState: (String) -> Unit,
    updateWriteTextState: (String) -> Unit,
    updateLinkTextState: (String) -> Unit,
    checkButtonOnClick: () -> Unit,
    navigateToBack: () -> Unit,
) {
    val focusManager = LocalFocusManager.current
    val (checkBookDialog, toggleCheckBookDialog) = remember { mutableStateOf(false) }

    MindWayAndroidTheme { colors, _ ->
        CompositionLocalProvider(values = arrayOf(LocalFocusManager provides focusManager)) {
            Column(
                modifier = modifier
                    .fillMaxSize()
                    .background(color = colors.WHITE)
                    .pointerInput(Unit) {
                        detectTapGestures {
                            focusManager.clearFocus()
                        }
                    }
            ) {
                MindWayTopAppBar(
                    startIcon = { ChevronLeftIcon(modifier = Modifier.clickableSingle(onClick = navigateToBack)) },
                    midText = stringResource(R.string.book_request),
                )
                Column(
                    verticalArrangement = Arrangement.spacedBy(28.dp, Alignment.Top),
                    horizontalAlignment = Alignment.Start,
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(
                            horizontal = 24.dp,
                            vertical = 28.dp
                        )
                ) {
                    if (checkBookDialog) {
                        Dialog(onDismissRequest = { toggleCheckBookDialog(false) }) {
                            BookPopUp(
                                onDismiss = { toggleCheckBookDialog(false) }
                            )
                        }
                    }
                    MindWayTextFieldNoneLimit(
                        title = stringResource(id = R.string.title),
                        textState = titleTextState,
                        placeholder = stringResource(R.string.please_enter_the_book_title),
                        emptyErrorMessage = stringResource(R.string.please_enter_the_book_title),
                        updateTextValue = updateTitleTextState,
                        isError = titleTextStateIsEmpty
                    )
                    MindWayTextFieldNoneLimit(
                        title = stringResource(id = R.string.writer),
                        textState = writeTextState,
                        placeholder = stringResource(id = R.string.please_enter_the_book_writer),
                        emptyErrorMessage = stringResource(id = R.string.please_enter_the_book_writer),
                        updateTextValue = updateWriteTextState,
                        isError = writeTextStateIsEmpty
                    )
                    MindWayTextFieldNoneLimit(
                        title = stringResource(id = R.string.link),
                        textState = linkTextState,
                        placeholder = stringResource(id = R.string.please_enter_the_link),
                        emptyErrorMessage = stringResource(id = R.string.please_enter_the_link),
                        updateTextValue = updateLinkTextState,
                        isError = linkTextStateIsEmpty
                    )
                    Spacer(modifier = modifier.weight(1f))
                    MindWayButton(
                        text = stringResource(id = R.string.apply),
                        onClick = {
                            if (
                                !titleTextStateIsEmpty
                                && !writeTextStateIsEmpty
                                && !linkTextStateIsEmpty
                            ) {
                                navigateToBack()
                            }
                            checkButtonOnClick()
                        },
                        modifier = modifier
                            .fillMaxWidth()
                            .height(56.dp),
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewAddBookScreen() {
    BookAddBookScreen(
        navigateToBack = {},
        checkButtonOnClick = {},
        linkTextState = "",
        linkTextStateIsEmpty = false,
        titleTextStateIsEmpty = false,
        writeTextState = "",
        titleTextState = "",
        updateTitleTextState = { _ -> },
        updateLinkTextState = { _ -> },
        updateWriteTextState = { _ -> },
        writeTextStateIsEmpty = false
    )
}