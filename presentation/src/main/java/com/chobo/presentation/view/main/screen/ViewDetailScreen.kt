package com.chobo.presentation.view.main.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chobo.presentation.R
import com.chobo.presentation.view.main.component.ViewDetailTextCard

@Composable
fun ViewDetailScreen(
    titleContent: String,
    contentString: String,
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(20.dp, Alignment.Top),
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                vertical = 24.dp,
                horizontal = 28.dp,
            )
    ) {
        ViewDetailTextCard(
            title = stringResource(R.string.title),
            content = titleContent,
        )
        ViewDetailTextCard(
            title = stringResource(R.string.content),
            content = contentString,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ViewDetailScreenPreview() {
    ViewDetailScreen(
        titleContent = "fgyiuhoijpkxrtcytvuybxdfcghvjbkn",
        contentString = "xdtcfvgbhjknlmnbfvsdcastfcyvgubhnjmkrbevrwcsxdvhbjncfgvhjb\nfcghgvjbkjcfhgvjb\nfcghvjbfchgvjb\n\nfcgvhbfchgvjbgv",
    )
}