package com.chobo.presentation.view.book.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chobo.presentation.R
import com.chobo.presentation.view.component.button.MindWayButton
import com.chobo.presentation.view.main.screen.MockOnClick
import com.chobo.presentation.view.theme.MindWayAndroidTheme

@Composable
fun BookPopUp(
    onClick: () -> Unit,
) {
    MindWayAndroidTheme { colors, typography ->
        Column(
            verticalArrangement = Arrangement.spacedBy(10.dp, Alignment.Top),
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .shadow(
                    elevation = 20.dp,
                    spotColor = colors.CardShadow,
                    ambientColor = colors.CardShadow
                )
                .background(
                    color = colors.WHITE,
                    shape = RoundedCornerShape(size = 8.dp)
                )
                .padding(
                    horizontal = 24.dp,
                    vertical = 28.dp
                )
        ) {
            Text(
                text = stringResource(R.string.book_request_confirm),
                style = typography.bodySmall,
                fontWeight = FontWeight.Normal,
                color = colors.Black,
                textAlign = TextAlign.Center,
            )
            MindWayButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                text = stringResource(R.string.check),
                onClick = { onClick() }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BookPopUpPreview() {
    BookPopUp(onClick = { MockOnClick() })
}