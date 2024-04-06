package com.chobo.presentation.view.my.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
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
import com.chobo.presentation.view.component.textField.MindWayTextField

@Composable
fun MyBookEditScreen(
    title: String,
    writer: String,
    link: String,
) {
    val titleState = remember { mutableStateOf(title) }
    val writerState = remember { mutableStateOf(writer) }
    val linkState = remember { mutableStateOf(link) }
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
            textState = titleState,
            placeholder = stringResource(R.string.please_enter_the_book_title),
            isError = false,
            errorMessage = stringResource(R.string.please_enter_the_book_title)
        )
        MindWayTextField(
            title = stringResource(R.string.writer),
            textState = writerState,
            placeholder = stringResource(R.string.please_enter_the_book_writer),
            isError = false,
            errorMessage = stringResource(R.string.please_enter_the_book_writer)
        )
        MindWayTextField(
            title = stringResource(R.string.link),
            textState = linkState,
            placeholder = stringResource(R.string.please_enter_the_link),
            isError = false,
            errorMessage = stringResource(R.string.please_enter_the_link)
        )
    }
}
@Preview(showBackground = true)
@Composable
fun MyBookEditScreenPreview() {
    MyBookEditScreen(title = "제가그랬습니다", writer = "너가그랬습니다(저자)", link = "https://github.com/answad")
}