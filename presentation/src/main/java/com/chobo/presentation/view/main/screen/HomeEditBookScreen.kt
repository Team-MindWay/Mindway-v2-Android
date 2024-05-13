package com.chobo.presentation.view.main.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.chobo.presentation.R
import com.chobo.presentation.view.component.button.MindWayButton
import com.chobo.presentation.view.component.icon.ChevronLeftIcon
import com.chobo.presentation.view.component.icon.InfoIcon
import com.chobo.presentation.view.component.multipleEventsCutterManager.clickableSingle
import com.chobo.presentation.view.component.textField.MindWayTextField
import com.chobo.presentation.view.component.textField.MindWayTextFieldNoneLimit
import com.chobo.presentation.view.component.topBar.MindWayTopAppBar
import com.chobo.presentation.view.theme.MindWayAndroidTheme
import com.chobo.presentation.viewModel.main.HomeAddBookViewModel

@Composable
internal fun HomeEditBookRoute(
    modifier: Modifier = Modifier,
    homeAddBookViewModel: HomeAddBookViewModel = viewModel(),
    navigateToBack: () -> Unit
) {
    val titleTextState by homeAddBookViewModel.titleTextState.collectAsStateWithLifecycle()
    val contentTextState by homeAddBookViewModel.contentTextState.collectAsStateWithLifecycle()
    val titleTextStateIsEmpty by homeAddBookViewModel.titleTextStateIsEmpty.collectAsStateWithLifecycle()
    val contentTextStateIsEmpty by homeAddBookViewModel.contentTextStateIsEmpty.collectAsStateWithLifecycle()
    val contentTextMaxLength = homeAddBookViewModel.contentTextMaxLength

    HomeEditBookScreen(
        modifier = modifier,
        titleTextState = titleTextState,
        contentTextState = contentTextState,
        titleTextStateIsEmpty = titleTextStateIsEmpty,
        contentTextStateIsEmpty = contentTextStateIsEmpty,
        contentTextMaxLength = contentTextMaxLength,
        updateTitleTextState = homeAddBookViewModel::updateTitleTextState,
        updateContentTextState = homeAddBookViewModel::updateContentTextState,
        checkButtonOnClick = homeAddBookViewModel::checkButtonOnClick,
        navigateToBack = navigateToBack,
    )
}

@Composable
internal fun HomeEditBookScreen(
    modifier: Modifier = Modifier,
    titleTextState: String,
    contentTextState: String,
    titleTextStateIsEmpty: Boolean,
    contentTextStateIsEmpty: Boolean,
    contentTextMaxLength: Int,
    updateTitleTextState: (String) -> Unit,
    updateContentTextState: (String) -> Unit,
    checkButtonOnClick: () -> Unit,
    navigateToBack: () -> Unit,
) {
    MindWayAndroidTheme { colors, _ ->
        Column(modifier = modifier.background(color = colors.WHITE)) {
            MindWayTopAppBar(
                startIcon = { ChevronLeftIcon(modifier = Modifier.clickableSingle(onClick = navigateToBack)) },
                endIcon = { InfoIcon(modifier = Modifier.clickableSingle(onClick = { })) },
                midText = stringResource(R.string.book_modify),
            )
            Column(
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.Start,
                modifier = Modifier.fillMaxSize()
            ) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(20.dp, Alignment.Top),
                    horizontalAlignment = Alignment.Start,
                    modifier = Modifier
                        .padding(
                            horizontal = 24.dp,
                            vertical = 28.dp
                        )
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
                        lengthLimit = contentTextMaxLength,
                        updateTextValue = updateContentTextState,
                        isError = contentTextStateIsEmpty
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    MindWayButton(
                        text = stringResource(R.string.check),
                        onClick = checkButtonOnClick,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(60.dp),
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeBookEditScreenPreview() {
    HomeEditBookRoute(navigateToBack = { })
}