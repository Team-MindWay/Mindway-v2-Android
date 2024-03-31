package com.chobo.presentation.view.component.textField

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.chobo.presentation.view.theme.MindWayAndroidTheme


@Composable
fun MindWayTextField(
    modifier: Modifier = Modifier,
    title: String,
    textState: MutableState<String>,
    hint: String,
    isError: Boolean,
    errorMessage: String,
) {
    MindWayAndroidTheme { colors, typography ->
        Column(
            verticalArrangement = Arrangement.spacedBy(4.dp, Alignment.Top),
            horizontalAlignment = Alignment.Start,
        ) {
            Text(
                text = title,

                style = typography.labelLarge,
                fontWeight = FontWeight.Normal,
                color = colors.GRAY400,
            )
            BasicTextField(
                onValueChange = { newText -> textState.value = newText },
                value = textState.value,
                decorationBox = {
                    Row (
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxHeight()
                    ){
                        if (textState.value == "") {
                            Text(
                                text = hint,
                                style = TextStyle(color = colors.GRAY500),
                            )
                        }
                    }
                },
                modifier = modifier
                    .border(
                        width = 1.dp,
                        color = if (isError) colors.SYSTEM
                        else colors.GRAY100,
                        shape = RoundedCornerShape(size = 8.dp)
                    )
                    .fillMaxSize()
                    .background(
                        color = colors.GRAY100,
                        shape = RoundedCornerShape(size = 8.dp)
                    )
                    .padding(15.dp),
            )
            if (isError) {
                Text(
                    text = errorMessage,

                    style = typography.labelLarge,
                    fontWeight = FontWeight.Normal,
                    color = colors.SYSTEM
                )
            }
        }
    }
}