package com.chobo.presentation.view.main.component

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chobo.presentation.R
import com.chobo.presentation.view.component.button.MindWayButton
import com.chobo.presentation.view.component.textField.MindWayTextField
import com.chobo.presentation.view.theme.MindWayAndroidTheme

@Composable
fun GoalReadingBottomSheet(
    textState: String,
    isError: Boolean,
    updateTextValue: (String) -> Unit,
    onclick: () -> Unit,
) {
    val focusManager = LocalFocusManager.current

    MindWayAndroidTheme { colors, typography ->
        CompositionLocalProvider(LocalFocusManager provides focusManager) {
            Column(
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.Start,
                modifier = Modifier
                    .pointerInput(Unit) {
                        detectTapGestures {
                            focusManager.clearFocus()
                        }
                    }
                    .imePadding()
                    .fillMaxWidth()
                    .height(313.dp)
                    .background(
                        color = colors.WHITE,
                        shape = RoundedCornerShape(
                            topEnd = 12.dp,
                            topStart = 12.dp,
                        )
                    )
                    .padding(
                        start = 24.dp,
                        top = 28.dp,
                        end = 24.dp,
                        bottom = 36.dp
                    )
            ) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(20.dp, Alignment.Top),
                    horizontalAlignment = Alignment.Start,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(
                        verticalArrangement = Arrangement.spacedBy(4.dp, Alignment.Top),
                        horizontalAlignment = Alignment.Start,
                        modifier = Modifier.height(52.dp)
                    ) {
                        Text(
                            text = "기간",
                            style = typography.labelLarge,
                            fontWeight = FontWeight.Normal,
                            color = colors.GRAY400,
                        )
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(12.dp, Alignment.Start),
                            verticalAlignment = Alignment.Top,
                        ) {
                            val textList = listOf(
                                stringResource(id = R.string.month_day, 3, 24),
                                stringResource(id = R.string.wave),
                                stringResource(id = R.string.month_day, 3, 21)
                            )
                            textList.forEach {
                                Text(
                                    text = it,
                                    style = typography.bodyMedium,
                                    fontWeight = FontWeight.SemiBold,
                                    color = colors.Black,
                                )
                            }
                        }
                    }
                    MindWayTextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(119.dp),
                        title = stringResource(id = R.string.goal_reading),
                        textState = textState,
                        placeholder = "권",
                        isTextRight = true,
                        emptyErrorMessage = stringResource(R.string.goal_reading_error),
                        updateTextValue = updateTextValue,
                        isError = isError,
                    )
                }
                MindWayButton(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(),
                    text = stringResource(id = R.string.check),
                    onClick = onclick
                )
            }
        }
    }
}

@Preview(name = "GoalReadingBottomSheetErrorPreview")
@Composable
fun GoalReadingBottomSheetErrorPreview() {
    GoalReadingBottomSheet(textState = "", updateTextValue = {}, onclick = { }, isError = true)
}

@Preview(name = "GoalReadingBottomSheetNoErrorPreview")
@Composable
fun GoalReadingBottomSheetNoErrorPreview() {
    GoalReadingBottomSheet(textState = "", updateTextValue = {}, onclick = { }, isError = false)
}