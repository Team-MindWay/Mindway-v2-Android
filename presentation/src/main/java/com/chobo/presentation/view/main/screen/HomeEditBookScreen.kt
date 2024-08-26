package com.chobo.presentation.view.main.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.chobo.presentation.R
import com.chobo.presentation.view.component.button.MindWayButton
import com.chobo.presentation.view.component.icon.ChevronLeftIcon
import com.chobo.presentation.view.component.icon.InfoIcon
import com.chobo.presentation.view.component.multipleEventsCutterManager.clickableSingle
import com.chobo.presentation.view.component.textField.MindWayTextField
import com.chobo.presentation.view.component.textField.MindWayTextFieldNoneLimit
import com.chobo.presentation.view.component.topBar.MindWayTopAppBar
import com.chobo.presentation.view.theme.MindWayAndroidTheme
import com.chobo.presentation.viewModel.main.HomeBookEditViewModel

@Composable
internal fun HomeEditBookRoute(
    modifier: Modifier = Modifier,
    homeBookEditViewModel: HomeBookEditViewModel = hiltViewModel(),
    id: Long,
    navigateToBack: () -> Unit,
) {
    val titleTextState by homeBookEditViewModel.titleTextState.collectAsStateWithLifecycle()
    val contentTextState by homeBookEditViewModel.plotTextState.collectAsStateWithLifecycle()
    val titleTextStateIsEmpty by homeBookEditViewModel.titleTextStateIsEmpty.collectAsStateWithLifecycle()
    val contentTextStateIsEmpty by homeBookEditViewModel.plotTextStateIsEmpty.collectAsStateWithLifecycle()

    HomeEditBookScreen(
        modifier = modifier,
        titleTextState = titleTextState,
        contentTextState = contentTextState,
        titleTextStateIsEmpty = titleTextStateIsEmpty,
        contentTextStateIsEmpty = contentTextStateIsEmpty,
        updateTitleTextState = homeBookEditViewModel::updateTitleTextState,
        updateContentTextState = homeBookEditViewModel::updatePlotTextState,
        checkButtonOnClick = {
            homeBookEditViewModel.checkButtonOnClick(id)
        },
        navigateToBack = navigateToBack,
    )
    LaunchedEffect(Unit) {
        homeBookEditViewModel.getBookById(id)
    }
}

@Composable
internal fun HomeEditBookScreen(
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
                midText = stringResource(R.string.book_modify),
            )
            Column(
                verticalArrangement = Arrangement.spacedBy(20.dp, Alignment.Top),
                horizontalAlignment = Alignment.Start,
                modifier = Modifier
                    .padding(vertical = 28.dp)
                    .fillMaxWidth()
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
                    onClick = {
                        checkButtonOnClick()
                        navigateToBack()
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp),
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeBookEditScreenPreview() {
    HomeEditBookScreen(navigateToBack = { },
        checkButtonOnClick = {},
        contentTextState = "",
        contentTextStateIsEmpty = false,
        titleTextStateIsEmpty = false,
        titleTextState = "",
        updateTitleTextState = { _ -> },
        updateContentTextState = { _ -> }
    )
}