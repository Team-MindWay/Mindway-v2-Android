package com.chobo.presentation.view.book.screen

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
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import com.chobo.presentation.view.component.textField.MindWayTextField
import com.chobo.presentation.view.theme.MindWayAndroidTheme
import com.chobo.presentation.viewModel.BookAddBookViewModel

@Composable
fun BookAddBookScreen(
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
    var checkBookDialog by remember { mutableStateOf(false) }
    val focusManager = LocalFocusManager.current

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
                BookRequestTopAppBar(startIconOnClick = { navigateToBack() })
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
                        Dialog(onDismissRequest = { checkBookDialog = false }) {
                            BookPopUp(
                                onDismiss = { checkBookDialog = false }
                            )
                        }
                    }
                    MindWayTextField(
                        title = stringResource(id = R.string.title),
                        textState = titleTextState,
                        placeholder = stringResource(R.string.please_enter_the_book_title),
                        emptyErrorMessage = stringResource(R.string.please_enter_the_book_title),
                        updateTextValue = bookAddBookViewModel::updateTitleTextState,
                        isError = titleTextStateIsEmpty
                    )
                    MindWayTextField(
                        title = stringResource(id = R.string.writer),
                        textState = writeTextState,
                        placeholder = stringResource(id = R.string.please_enter_the_book_writer),
                        emptyErrorMessage = stringResource(id = R.string.please_enter_the_book_writer),
                        updateTextValue = bookAddBookViewModel::updateWriteTextState,
                        isError = writeTextStateIsEmpty
                    )
                    MindWayTextField(
                        title = stringResource(id = R.string.link),
                        textState = linkTextState,
                        placeholder = stringResource(id = R.string.please_enter_the_link),
                        emptyErrorMessage = stringResource(id = R.string.please_enter_the_link),
                        updateTextValue = bookAddBookViewModel::updateLinkTextState,
                        isError = linkTextStateIsEmpty
                    )
                    Spacer(modifier = modifier.weight(1f))
                    MindWayButton(
                        text = stringResource(id = R.string.apply),
                        modifier = modifier
                            .fillMaxWidth()
                            .height(56.dp),
                        onClick = bookAddBookViewModel::checkButtonOnClick
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewAddBookScreen() {
    BookAddBookScreen(navigateToBack = { })
}