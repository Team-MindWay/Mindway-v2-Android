package com.chobo.presentation.view.my.screen

import androidx.activity.ComponentActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.chobo.domain.model.my.MyBookListModel
import com.chobo.presentation.R
import com.chobo.presentation.view.component.button.MindWayButton
import com.chobo.presentation.view.component.icon.ChevronLeftIcon
import com.chobo.presentation.view.component.multipleEventsCutterManager.clickableSingle
import com.chobo.presentation.view.component.textField.MindWayTextFieldNoneLimit
import com.chobo.presentation.view.component.topBar.MindWayTopAppBar
import com.chobo.presentation.view.theme.MindWayAndroidTheme
import com.chobo.presentation.viewModel.my.MyViewModel

@Composable
internal fun MyBookEditRoute(
    modifier: Modifier = Modifier,
    myViewModel: MyViewModel = hiltViewModel(LocalContext.current as ComponentActivity),
    navigateToBack: () -> Unit,
) {
    val (titleTextState, updateTitleTextState) = remember { mutableStateOf("") }
    val (writeTextState, updateWriteTextState) = remember { mutableStateOf("") }
    val (linkTextState, updateLinkTextState) = remember { mutableStateOf("") }
    val (titleTextStateIsEmpty, updateTitleTextStateIsEmpty) = remember { mutableStateOf(false) }
    val (writeTextStateIsEmpty, updateWriteTextStateIsEmpty) = remember { mutableStateOf(false) }
    val (linkTextStateIsEmpty, updateLinkTextStateIsEmpty) = remember { mutableStateOf(false) }

    MyBookEditScreen(
        modifier = modifier,
        titleTextState = titleTextState,
        writeTextState = writeTextState,
        linkTextState = linkTextState,
        titleTextStateIsEmpty = titleTextStateIsEmpty,
        writeTextStateIsEmpty = writeTextStateIsEmpty,
        linkTextStateIsEmpty = linkTextStateIsEmpty,
        updateTitleTextState = { textState ->
            updateTitleTextState(textState)
            updateTitleTextStateIsEmpty(false)
        },
        updateWriteTextState = { textState ->
            updateWriteTextState(textState)
            updateWriteTextStateIsEmpty(false)
        },
        updateLinkTextState = { textState ->
            updateLinkTextState(textState)
            updateLinkTextStateIsEmpty(false)
        },
        orderModifyById = {
            updateTitleTextStateIsEmpty(titleTextState.isEmpty())
            updateWriteTextStateIsEmpty(writeTextState.isEmpty())
            updateLinkTextStateIsEmpty(linkTextState.isEmpty())
            if (
                titleTextState.isNotEmpty()
                && writeTextState.isNotEmpty()
                && linkTextState.isNotEmpty()
            ) {
                myViewModel.orderModifyById(
                    body = MyBookListModel(
                        id = myViewModel.myBookItem.id,
                        author = writeTextState,
                        title = titleTextState,
                        bookUrl = linkTextState,
                    )
                )
                navigateToBack()
            }
        },
        navigateToBack = navigateToBack,
    )

    LaunchedEffect(Unit) {
        myViewModel.myBookItem.let { book ->
            updateTitleTextState(book.title)
            updateWriteTextState(book.author)
            updateLinkTextState(book.bookUrl)
        }
    }
}

@Composable
internal fun MyBookEditScreen(
    modifier: Modifier = Modifier,
    focusManager: FocusManager = LocalFocusManager.current,
    titleTextState: String,
    writeTextState: String,
    linkTextState: String,
    titleTextStateIsEmpty: Boolean,
    writeTextStateIsEmpty: Boolean,
    linkTextStateIsEmpty: Boolean,
    updateTitleTextState: (String) -> Unit,
    updateWriteTextState: (String) -> Unit,
    updateLinkTextState: (String) -> Unit,
    orderModifyById: () -> Unit,
    navigateToBack: () -> Unit,
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
                MindWayTopAppBar(
                    startIcon = { ChevronLeftIcon(modifier = Modifier.clickableSingle(onClick = navigateToBack)) },
                    midText = stringResource(R.string.book_modify),
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
                        onClick = orderModifyById,
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
    MyBookEditScreen(
        navigateToBack = { },
        linkTextState = "",
        titleTextState = "",
        updateTitleTextState = { _ -> },
        writeTextState = "",
        writeTextStateIsEmpty = false,
        linkTextStateIsEmpty = false,
        updateLinkTextState = { _ -> },
        titleTextStateIsEmpty = false,
        updateWriteTextState = { _ -> },
        orderModifyById = { }
    )
}