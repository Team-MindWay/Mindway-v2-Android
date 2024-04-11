package com.chobo.presentation.view.my.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.chobo.presentation.R
import com.chobo.presentation.view.component.button.MindWayButton
import com.chobo.presentation.view.component.textField.MindWayTextField
import com.chobo.presentation.view.theme.MindWayAndroidTheme
import com.chobo.presentation.viewModel.MyBookEditViewModel

@Composable
fun MyBookEditScreen(
    myBookEditViewModel: MyBookEditViewModel = viewModel()
) {
    val titleState = remember { mutableStateOf(myBookEditViewModel.titleTextState.value) }
    val writerState = remember { mutableStateOf(myBookEditViewModel.writeTextState.value) }
    val linkState = remember { mutableStateOf(myBookEditViewModel.linkTextState.value) }
MindWayAndroidTheme { colors, _ ->
    Column(
        verticalArrangement = Arrangement.spacedBy(28.dp, Alignment.Top),
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .fillMaxSize()
            .padding(
                horizontal = 24.dp,
                vertical = 28.dp
            )
            .imePadding()
    ) {
        MindWayTextField(
            title = stringResource(R.string.title),
            textState = titleState,
            placeholder = stringResource(R.string.please_enter_the_book_title),
            errorMessage = stringResource(R.string.please_enter_the_book_title)
        )
        MindWayTextField(
            title = stringResource(R.string.writer),
            textState = writerState,
            placeholder = stringResource(R.string.please_enter_the_book_writer),
            errorMessage = stringResource(R.string.please_enter_the_book_writer)
        )
        MindWayTextField(
            title = stringResource(R.string.link),
            textState = linkState,
            placeholder = stringResource(R.string.please_enter_the_link),
            errorMessage = stringResource(R.string.please_enter_the_link)
        )
        Spacer(modifier = Modifier.weight(1f))
        MindWayButton(
            text = stringResource(id = R.string.apply),
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            onClick = { myBookEditViewModel.checkButton() }
        )
    }
}
}
@Preview(showBackground = true)
@Composable
fun MyBookEditScreenPreview() {
    MyBookEditScreen()
}