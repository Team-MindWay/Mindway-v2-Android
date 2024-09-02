package com.chobo.presentation.view.book.component

import android.graphics.Color
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
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
import com.chobo.presentation.view.theme.MindWayAndroidTheme

@Composable
fun BookPopUp(
    modifier: Modifier = Modifier,
    onDismiss: () -> Unit
) {
    MindWayAndroidTheme { colors, typography ->
        Column(
            verticalArrangement = Arrangement.spacedBy(20.dp, Alignment.Top),
            horizontalAlignment = Alignment.Start,
            modifier = modifier
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
                text = stringResource(R.string.check),
                onClick = onDismiss,
                modifier = Modifier.padding(10.dp),
            )
        }
    }
}

@Preview(
    showBackground = true,
    backgroundColor = Color.BLACK.toLong()
)
@Composable
fun BookPopUpPreview() {
    BookPopUp(onDismiss = { })
}