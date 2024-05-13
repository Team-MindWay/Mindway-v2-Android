package com.chobo.presentation.view.book.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.chobo.presentation.R
import com.chobo.presentation.view.book.component.BookPopUp
import com.chobo.presentation.view.book.component.BookRequestTopAppBar
import com.chobo.presentation.view.component.button.MindWayButton
import com.chobo.presentation.view.component.textField.MindWayTextFieldNoneLimit
import com.chobo.presentation.view.theme.MindWayAndroidTheme
import com.chobo.presentation.viewModel.book.BookAddBookViewModel

@Composable
internal fun BookAddBookRoute(
    modifier: Modifier = Modifier,
    bookAddBookViewModel: BookAddBookViewModel = viewModel(),
    navigateToBack: () -> Unit
) {
    val titleTextState by bookAddBookViewModel.titleTextState.collectAsStateWithLifecycle()
    val writeTextState by bookAddBookViewModel.writeTextState.collectAsStateWithLifecycle()
    val linkTextState by bookAddBookViewModel.linkTextState.collectAsStateWithLifecycle()
    val titleTextStateIsEmpty by bookAddBookViewModel.titleTextStateIsEmpty.collectAsStateWithLifecycle()
    val writeTextStateIsEmpty by bookAddBookViewModel.writeTextStateIsEmpty.collectAsStateWithLifecycle()
    val linkTextStateIsEmpty by bookAddBookViewModel.linkTextStateIsEmpty.collectAsStateWithLifecycle()
    val checkBookDialog by bookAddBookViewModel.checkBookDialog.collectAsStateWithLifecycle()
    val focusManager = LocalFocusManager.current

    BookAddBookScreen(
        modifier = modifier,
        titleTextState = titleTextState,
        writeTextState = writeTextState,
        linkTextState = linkTextState,
        titleTextStateIsEmpty = titleTextStateIsEmpty,
        writeTextStateIsEmpty = writeTextStateIsEmpty,
        linkTextStateIsEmpty = linkTextStateIsEmpty,
        checkBookDialog = checkBookDialog,
        focusManager = focusManager,
        updateTitleTextState = bookAddBookViewModel::updateTitleTextState,
        updateWriteTextState = bookAddBookViewModel::updateWriteTextState,
        updateLinkTextState = bookAddBookViewModel::updateLinkTextState,
        toggleCheckBookDialog = bookAddBookViewModel::toggleCheckBookDialog,
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
    checkBookDialog: Boolean,
    focusManager: FocusManager,
    updateTitleTextState: (String) -> Unit,
    updateWriteTextState: (String) -> Unit,
    updateLinkTextState: (String) -> Unit,
    toggleCheckBookDialog: () -> Unit,
    checkButtonOnClick: () -> Unit,
    navigateToBack: () -> Unit,
) {
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
                BookRequestTopAppBar(startIconOnClick = navigateToBack)
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
                        Dialog(onDismissRequest = toggleCheckBookDialog) {
                            BookPopUp(
                                onDismiss = toggleCheckBookDialog
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
                        onClick = checkButtonOnClick,
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
    BookAddBookRoute {}
}