package com.chobo.presentation.view.my.screen

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
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.chobo.presentation.R
import com.chobo.presentation.view.component.button.MindWayButton
import com.chobo.presentation.view.component.textField.MindWayTextField
import com.chobo.presentation.view.my.component.BookEditTopAppBar
import com.chobo.presentation.view.theme.MindWayAndroidTheme
import com.chobo.presentation.viewModel.my.MyBookEditViewModel

@Composable
fun MyBookEditScreen(
    modifier: Modifier = Modifier,
    myBookEditViewModel: MyBookEditViewModel = viewModel(),
    navigateToBack: () -> Unit,
) {
    val titleTextState by myBookEditViewModel.titleTextState.collectAsStateWithLifecycle()
    val writeTextState by myBookEditViewModel.writeTextState.collectAsStateWithLifecycle()
    val linkTextState by myBookEditViewModel.linkTextState.collectAsStateWithLifecycle()
    val titleTextStateIsEmpty by myBookEditViewModel.titleTextStateIsEmpty.collectAsStateWithLifecycle()
    val writeTextStateIsEmpty by myBookEditViewModel.writeTextStateIsEmpty.collectAsStateWithLifecycle()
    val linkTextStateIsEmpty by myBookEditViewModel.linkTextStateIsEmpty.collectAsStateWithLifecycle()
    val focusManager = LocalFocusManager.current

    MindWayAndroidTheme { colors, _ ->
        CompositionLocalProvider(LocalFocusManager provides focusManager) {
            Column(modifier = modifier
                .background(colors.WHITE)
                .pointerInput(Unit) {
                    detectTapGestures{
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
                    MindWayTextField(
                        title = stringResource(R.string.title),
                        textState = titleTextState,
                        placeholder = stringResource(R.string.please_enter_the_book_title),
                        emptyErrorMessage = stringResource(R.string.please_enter_the_book_title),
                        updateTextValue = myBookEditViewModel::updateTitleTextState,
                        isError = titleTextStateIsEmpty
                    )
                    MindWayTextField(
                        title = stringResource(R.string.writer),
                        textState = writeTextState,
                        placeholder = stringResource(R.string.please_enter_the_book_writer),
                        emptyErrorMessage = stringResource(R.string.please_enter_the_book_writer),
                        updateTextValue = myBookEditViewModel::updateWriteTextState,
                        isError = writeTextStateIsEmpty
                    )
                    MindWayTextField(
                        title = stringResource(R.string.link),
                        textState = linkTextState,
                        placeholder = stringResource(R.string.please_enter_the_link),
                        emptyErrorMessage = stringResource(R.string.please_enter_the_link),
                        updateTextValue = myBookEditViewModel::updateLinkTextState,
                        isError = linkTextStateIsEmpty
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    MindWayButton(
                        text = stringResource(id = R.string.apply),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(56.dp),
                        onClick = myBookEditViewModel::checkButtonOnClick
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MyBookEditScreenPreview() {
    MyBookEditScreen(navigateToBack = { } )
}