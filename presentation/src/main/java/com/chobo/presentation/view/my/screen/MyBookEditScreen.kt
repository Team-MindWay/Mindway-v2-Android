package com.chobo.presentation.view.my.screen

import androidx.activity.ComponentActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.chobo.presentation.R
import com.chobo.presentation.view.component.button.MindWayButton
import com.chobo.presentation.view.component.textField.MindWayTextFieldNoneLimit
import com.chobo.presentation.view.my.component.BookEditTopAppBar
import com.chobo.presentation.view.theme.MindWayAndroidTheme
import com.chobo.presentation.viewModel.my.MyBookEditViewModel

@Composable
internal fun MyBookEditRoute(
    modifier: Modifier = Modifier,
    navigateToBack: () -> Unit,
    myBookEditViewModel: MyBookEditViewModel = viewModel(LocalContext.current as ComponentActivity)
) {
    val titleTextState by myBookEditViewModel.titleTextState.collectAsStateWithLifecycle()
    val writeTextState by myBookEditViewModel.writeTextState.collectAsStateWithLifecycle()
    val linkTextState by myBookEditViewModel.linkTextState.collectAsStateWithLifecycle()
    val titleTextStateIsEmpty by myBookEditViewModel.titleTextStateIsEmpty.collectAsStateWithLifecycle()
    val writeTextStateIsEmpty by myBookEditViewModel.writeTextStateIsEmpty.collectAsStateWithLifecycle()
    val linkTextStateIsEmpty by myBookEditViewModel.linkTextStateIsEmpty.collectAsStateWithLifecycle()
    val focusManager = LocalFocusManager.current

    MyBookEditScreen(
        modifier = modifier,
        navigateToBack = navigateToBack,
        focusManager = focusManager,
        titleTextState = titleTextState,
        writeTextState = writeTextState,
        linkTextState = linkTextState,
        titleTextStateIsEmpty = titleTextStateIsEmpty,
        writeTextStateIsEmpty = writeTextStateIsEmpty,
        linkTextStateIsEmpty = linkTextStateIsEmpty,
        updateTitleTextState = myBookEditViewModel::updateTitleTextState,
        updateWriteTextState = myBookEditViewModel::updateWriteTextState,
        updateLinkTextState = myBookEditViewModel::updateLinkTextState,
        checkButtonOnClick = myBookEditViewModel::checkButtonOnClick
    )
}

@Composable
internal fun MyBookEditScreen(
    modifier: Modifier = Modifier,
    navigateToBack: () -> Unit,
    focusManager: FocusManager,
    titleTextState: String,
    writeTextState: String,
    linkTextState: String,
    titleTextStateIsEmpty: Boolean,
    writeTextStateIsEmpty: Boolean,
    linkTextStateIsEmpty: Boolean,
    updateTitleTextState: (String) -> Unit,
    updateWriteTextState: (String) -> Unit,
    updateLinkTextState: (String) -> Unit,
    checkButtonOnClick: () -> Unit
) {
    MindWayAndroidTheme { colors, _ ->
        CompositionLocalProvider(LocalFocusManager provides focusManager) {
            Column(modifier = modifier
                .background(colors.WHITE)
                .pointerInput(Unit) {
                    detectTapGestures {
                        focusManager.clearFocus()
                    }
                }
                .imePadding()
            ) {
                BookEditTopAppBar(
                    startIconOnClick = navigateToBack,
                    endIconOnClick = {}
                )
                Column(
                    verticalArrangement = Arrangement.spacedBy(28.dp, Alignment.Top),
                    horizontalAlignment = Alignment.Start,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(
                            horizontal = 24.dp,
                            vertical = 28.dp
                        )
                ) {
                    MindWayTextFieldNoneLimit(
                        title = stringResource(R.string.title),
                        textState = titleTextState,
                        placeholder = stringResource(R.string.please_enter_the_book_title),
                        emptyErrorMessage = stringResource(R.string.please_enter_the_book_title),
                        updateTextValue = updateTitleTextState,
                        isError = titleTextStateIsEmpty
                    )
                    MindWayTextFieldNoneLimit(
                        title = stringResource(R.string.writer),
                        textState = writeTextState,
                        placeholder = stringResource(R.string.please_enter_the_book_writer),
                        emptyErrorMessage = stringResource(R.string.please_enter_the_book_writer),
                        updateTextValue = updateWriteTextState,
                        isError = writeTextStateIsEmpty
                    )
                    MindWayTextFieldNoneLimit(
                        title = stringResource(R.string.link),
                        textState = linkTextState,
                        placeholder = stringResource(R.string.please_enter_the_link),
                        emptyErrorMessage = stringResource(R.string.please_enter_the_link),
                        updateTextValue = updateLinkTextState,
                        isError = linkTextStateIsEmpty
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    MindWayButton(
                        text = stringResource(id = R.string.apply),
                        onClick = checkButtonOnClick,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(56.dp),
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MyBookEditScreenPreview() {
    MyBookEditRoute(navigateToBack = { })
}