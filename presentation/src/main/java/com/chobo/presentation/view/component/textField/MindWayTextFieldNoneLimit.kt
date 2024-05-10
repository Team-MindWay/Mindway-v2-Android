package com.chobo.presentation.view.component.textField

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chobo.presentation.view.theme.MindWayAndroidTheme

@Composable
fun MindWayTextFieldNoneLimit(
    modifier: Modifier = Modifier,
    title: String,
    textState: String,
    placeholder: String,
    emptyErrorMessage: String,
    isError: Boolean,
    updateTextValue: (String) -> Unit,
) {
    MindWayAndroidTheme { colors, typography ->
        Column(
            verticalArrangement = Arrangement.spacedBy(4.dp, Alignment.Top),
            horizontalAlignment = Alignment.Start,
            modifier = modifier.background(color = colors.WHITE)
        ) {
            Column {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = title,
                        style = typography.labelLarge,
                        fontWeight = FontWeight.Normal,
                        color = colors.GRAY400,
                    )
                }
                LazyColumn {
                    item {
                        Box(

                            modifier = Modifier
                                .border(
                                    width = 1.dp,
                                    color = if (isError) colors.SYSTEM else colors.GRAY100,
                                    shape = RoundedCornerShape(size = 8.dp)
                                )
                                .background(
                                    color = colors.GRAY100,
                                    shape = RoundedCornerShape(size = 8.dp)
                                )
                        ) {
                            Row(
                                horizontalArrangement = Arrangement.spacedBy(4.dp, Alignment.End),
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(16.dp)
                            ) {
                                BasicTextField(
                                    onValueChange = { newText ->
                                        updateTextValue(newText)
                                    },
                                    value = textState,
                                    textStyle = typography.bodySmall.copy(
                                        fontWeight = FontWeight.Normal,
                                        color = colors.Black,
                                        textAlign = TextAlign.Start,
                                    ),
                                    cursorBrush = SolidColor(colors.MAIN),
                                    modifier = Modifier
                                        .fillMaxWidth()
                                )
                            }
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.Start,
                                modifier = Modifier
                                    .padding(16.dp)
                                    .fillMaxWidth()
                            ) {
                                if (textState.isEmpty()) {
                                    Text(
                                        text = placeholder,
                                        style = typography.bodySmall,
                                        fontWeight = FontWeight.Normal,
                                        color = colors.GRAY400,
                                    )
                                }
                            }
                        }
                    }
                }
            }
            if (isError) {
                Text(
                    text = emptyErrorMessage,
                    style = typography.labelLarge,
                    fontWeight = FontWeight.Normal,
                    color = colors.SYSTEM
                )
            }
        }
    }
}

@Preview
@Composable
fun MindWayTextFieldNoneLimitPreview() {
    MindWayTextFieldNoneLimit(
        title = "제목이다",
        textState = "가나다라",
        placeholder = "힌트다",
        emptyErrorMessage = "비어ㅆ습니다",
        updateTextValue = {},
        isError = true
    )
}