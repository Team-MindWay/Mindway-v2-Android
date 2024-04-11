package com.chobo.presentation.view.my.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chobo.presentation.R
import com.chobo.presentation.view.component.button.MindWayButton
import com.chobo.presentation.view.main.screen.MockOnClick
import com.chobo.presentation.view.theme.MindWayAndroidTheme

@Composable
fun MyBookDeletePopUp(
    title: String,
    cancelOnclick: () -> Unit,
    checkOnclick: () -> Unit,
) {
    MindWayAndroidTheme { colors, typography ->
        Column(
            verticalArrangement = Arrangement.spacedBy(28.dp, Alignment.Top),
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .background(
                    color = colors.WHITE,
                    shape = RoundedCornerShape(size = 8.dp)
                )
                .padding(
                    start = 24.dp,
                    top = 24.dp,
                    end = 24.dp,
                    bottom = 20.dp
                )
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(12.dp, Alignment.Top),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Row {
                    Text(
                        text = stringResource(R.string.request_book),
                        style = typography.bodySmall,
                        fontWeight = FontWeight.Normal,
                        color = colors.Black,
                    )
                    Text(
                        text = stringResource(R.string.delete),
                        style = typography.bodySmall,
                        fontWeight = FontWeight.Normal,
                        color = colors.MAIN,
                    )
                    Text(
                        text = stringResource(R.string.pr),
                        style = typography.bodySmall,
                        fontWeight = FontWeight.Normal,
                        color = colors.Black,
                    )
                }
                Row(
                    horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterHorizontally),
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(
                            width = 1.dp,
                            color = colors.GRAY200,
                            shape = RoundedCornerShape(size = 8.dp)
                        )
                        .padding(
                            horizontal = 20.dp,
                            vertical = 12.dp
                        )
                ) {
                    Text(
                        text = title,
                        style = typography.bodyMedium,
                        fontWeight = FontWeight.Normal,
                        color = colors.Black,
                    )
                }
            }
            Row(
                horizontalArrangement = Arrangement.spacedBy(6.dp, Alignment.Start),
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                MindWayButton(
                    modifier = Modifier
                        .weight(1f)
                        .padding(vertical = 12.dp),
                    text = stringResource(R.string.cancel),
                    onClick = { cancelOnclick() },
                    buttonColor = colors.GRAY600
                )
                MindWayButton(
                    modifier = Modifier
                        .weight(1f)
                        .padding(vertical = 12.dp),
                    text = stringResource(R.string.check),
                    onClick = { checkOnclick() })
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MyBookDeletePopUpPreview() {
    MyBookDeletePopUp(
        title = "책의 제목입니다",
        cancelOnclick = { MockOnClick() },
        checkOnclick = { MockOnClick() })
}