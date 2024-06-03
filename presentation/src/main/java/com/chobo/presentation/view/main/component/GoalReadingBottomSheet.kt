package com.chobo.presentation.view.main.component

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.*
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
import com.chobo.presentation.view.component.textField.MindWayRightTextField
import com.chobo.presentation.view.theme.MindWayAndroidTheme
import com.chobo.presentation.viewModel.util.localDateTimeMonthDateFormat
import java.time.DayOfWeek
import java.time.LocalDateTime
import java.time.temporal.TemporalAdjusters

@Composable
fun GoalReadingBottomSheet(
    textState: String,
    updateTextValue: (String) -> Unit,
    onclick: () -> Unit,
    isError: Boolean,
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
                            val now = LocalDateTime.now()
                            val startOfWeek = now.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY))
                            val endOfWeek = now.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY))

                            Text(
                                text = stringResource(
                                    id = R.string.wave, localDateTimeMonthDateFormat(startOfWeek),
                                    localDateTimeMonthDateFormat(endOfWeek)
                                ),
                                style = typography.bodyMedium,
                                fontWeight = FontWeight.SemiBold,
                                color = colors.Black,
                            )
                        }
                    }
                    MindWayRightTextField(
                        title = stringResource(id = R.string.goal_reading),
                        textState = textState,
                        placeholder = "권",
                        emptyErrorMessage = stringResource(R.string.goal_reading_error),
                        updateTextValue = updateTextValue,
                        isError = isError,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(119.dp),
                    )
                }
                MindWayButton(
                    text = stringResource(id = R.string.check),
                    onClick = onclick,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }
}

@Preview
@Composable
fun GoalReadingBottomSheetPreview() {
    GoalReadingBottomSheet(textState = "dwq", updateTextValue = {}, { }, isError = false)
}