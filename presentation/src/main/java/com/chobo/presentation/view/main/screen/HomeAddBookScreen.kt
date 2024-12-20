package com.chobo.presentation.view.main.screen

import androidx.activity.ComponentActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
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
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.chobo.presentation.R
import com.chobo.presentation.view.component.button.MindWayButton
import com.chobo.presentation.view.component.icon.ChevronLeftIcon
import com.chobo.presentation.view.component.modifier.multipleEventsCutterManager.clickableSingle
import com.chobo.presentation.view.component.textField.MindWayTextField
import com.chobo.presentation.view.component.textField.MindWayTextFieldNoneLimit
import com.chobo.presentation.view.component.topBar.MindWayTopAppBar
import com.chobo.presentation.view.theme.MindWayAndroidTheme
import com.chobo.presentation.viewModel.main.HomeAddBookViewModel

@Composable
internal fun HomeAddBookRoute(
    modifier: Modifier = Modifier,
    homeAddBookViewModel: HomeAddBookViewModel = hiltViewModel(LocalContext.current as ComponentActivity),
    navigateToBack: () -> Unit,
) {
    LaunchedEffect(Unit) {
        homeAddBookViewModel.clearState()
    }

    val titleTextState by homeAddBookViewModel.titleTextState.collectAsStateWithLifecycle()
    val contentTextState by homeAddBookViewModel.contentTextState.collectAsStateWithLifecycle()
    val titleTextStateIsEmpty by homeAddBookViewModel.titleTextStateIsEmpty.collectAsStateWithLifecycle()
    val contentTextStateIsEmpty by homeAddBookViewModel.contentTextStateIsEmpty.collectAsStateWithLifecycle()

    HomeAddBookScreen(
        modifier = modifier,
        titleTextState = titleTextState,
        contentTextState = contentTextState,
        titleTextStateIsEmpty = titleTextStateIsEmpty,
        contentTextStateIsEmpty = contentTextStateIsEmpty,
        updateTitleTextState = homeAddBookViewModel::onTitleChanged,
        updateContentTextState = homeAddBookViewModel::onContentChanged,
        checkButtonOnClick = {
            if (homeAddBookViewModel.validateFields()) {
                homeAddBookViewModel.submitBook()
                homeAddBookViewModel.resetTextState()
                navigateToBack()
            }
        },
        navigateToBack = navigateToBack,
    )
}

@Composable
internal fun HomeAddBookScreen(
    modifier: Modifier = Modifier,
    focusManager: FocusManager = LocalFocusManager.current,
    titleTextState: String,
    contentTextState: String,
    titleTextStateIsEmpty: Boolean,
    contentTextStateIsEmpty: Boolean,
    updateTitleTextState: (String) -> Unit,
    updateContentTextState: (String) -> Unit,
    checkButtonOnClick: () -> Unit,
    navigateToBack: () -> Unit,
) {
    MindWayAndroidTheme { colors, _ ->
        Column(
            modifier = modifier
                .background(color = colors.WHITE)
                .pointerInput(Unit) {
                    detectTapGestures {
                        focusManager.clearFocus()
                    }
                }
                .padding(horizontal = 24.dp)
        ) {
            MindWayTopAppBar(
                startIcon = { ChevronLeftIcon(modifier = Modifier.clickableSingle(onClick = navigateToBack)) },
                midText = stringResource(R.string.add_book),
            )
            Column(
                verticalArrangement = Arrangement.spacedBy(20.dp, Alignment.Top),
                horizontalAlignment = Alignment.Start,
                modifier = Modifier
                    .padding(vertical = 28.dp)
                    .fillMaxSize()
            ) {
                MindWayTextFieldNoneLimit(
                    title = stringResource(R.string.title),
                    textState = titleTextState,
                    placeholder = stringResource(R.string.please_enter_the_book_title),
                    emptyErrorMessage = stringResource(R.string.please_enter_the_book_title),
                    updateTextValue = updateTitleTextState,
                    isError = titleTextStateIsEmpty
                )
                MindWayTextField(
                    title = stringResource(R.string.content),
                    textState = contentTextState,
                    placeholder = stringResource(R.string.please_enter_the_book_content),
                    overflowErrorMessage = stringResource(R.string.overFlowErrorMessage),
                    emptyErrorMessage = stringResource(R.string.error_content),
                    lengthLimit = 1000,
                    updateTextValue = updateContentTextState,
                    isError = contentTextStateIsEmpty
                )
                Spacer(modifier = Modifier.weight(1f))
                MindWayButton(
                    text = stringResource(R.string.check),
                    onClick = checkButtonOnClick,
                    modifier = Modifier.padding(16.dp),
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AddBookScreenPreview() {
    HomeAddBookScreen(
        navigateToBack = { },
        checkButtonOnClick = {},
        contentTextState = "",
        contentTextStateIsEmpty = false,
        titleTextState = "",
        titleTextStateIsEmpty = true,
        updateTitleTextState = {},
        updateContentTextState = {}
    )
}