package com.chobo.presentation.view.book.screen

import android.view.Window
import androidx.compose.foundation.background
import androidx.compose.foundation.indication
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chobo.presentation.view.component.textField.MindWayTextField
import com.chobo.presentation.view.theme.MindWayAndroidTheme
import com.chobo.presentation.R
import com.chobo.presentation.view.component.button.MindWayButton

@Composable
fun CheckOutBookScreen(
    modifier: Modifier = Modifier
) {
    val titleTextState = remember { mutableStateOf("") }
    val writeTextState = remember { mutableStateOf("") }
    val linkTextState = remember { mutableStateOf("") }

    MindWayAndroidTheme { colors, _ ->
        Column(
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = modifier
                .fillMaxSize()
                .background(color = colors.WHITE)
                .imePadding()
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(28.dp, Alignment.Top),
                horizontalAlignment = Alignment.Start,
                modifier = modifier
                    .fillMaxWidth()
                    .padding(start = 24.dp, end = 24.dp, top = 28.dp, bottom = 28.dp)
            ) {
                MindWayTextField(
                    title = stringResource(id = R.string.title),
                    textState = titleTextState,
                    placeholder = stringResource(R.string.please_enter_the_book_title),
                    isError = false,
                    errorMessage = stringResource(R.string.please_enter_the_book_title)
                )
                MindWayTextField(
                    title = stringResource(id = R.string.writer),
                    textState = writeTextState,
                    placeholder = stringResource(id = R.string.please_enter_the_book_writer),
                    isError = false,
                    errorMessage = stringResource(id = R.string.please_enter_the_book_writer)
                )
                MindWayTextField(
                    title = stringResource(id = R.string.link),
                    textState = linkTextState,
                    placeholder = stringResource(id = R.string.please_enter_the_link),
                    isError = false,
                    errorMessage = stringResource(id = R.string.please_enter_the_link)
                )
                Spacer(modifier = modifier.weight(1f))
                MindWayButton(
                    text = stringResource(id = R.string.apply),
                    modifier = modifier
                        .fillMaxWidth()
                        .height(48.dp)
                ) {
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewCheckOutBookScreen() {
    CheckOutBookScreen()
}