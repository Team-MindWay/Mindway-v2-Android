package com.chobo.presentation.view.main.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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
import com.chobo.presentation.R
import com.chobo.presentation.view.component.button.MindWayButton
import com.chobo.presentation.view.component.textField.MindWayTextField

@Composable
fun AddBookScreen() {
    val titleTextState = remember {
        mutableStateOf("")
    }
    val contentTextState = remember {
        mutableStateOf("")
    }
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .fillMaxSize()
            .imePadding()
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(20.dp, Alignment.Top),
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .padding(start = 24.dp, top = 28.dp, end = 24.dp, bottom = 28.dp)
                .fillMaxWidth()
        ) {
            MindWayTextField(
                title = stringResource(R.string.title),
                textState = titleTextState,
                placeholder = stringResource(R.string.please_enter_the_book_title),
                isError = false,
                errorMessage = stringResource(R.string.error_title),
                limiteInt = 60,
            )
            MindWayTextField(
                title = stringResource(R.string.content),
                textState = contentTextState,
                placeholder = stringResource(R.string.please_enter_the_book_content),
                isError = false,
                errorMessage = stringResource(R.string.error_content),
                limiteInt = 300,
            )
        }
        MindWayButton(
            text = stringResource(R.string.check),
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
        ) {
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AddBookScreenPreview() {
    AddBookScreen()
}