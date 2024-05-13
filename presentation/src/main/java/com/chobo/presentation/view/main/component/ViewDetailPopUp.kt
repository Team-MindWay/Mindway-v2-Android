package com.chobo.presentation.view.main.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import com.chobo.presentation.view.theme.MindWayAndroidTheme

@Composable
fun ViewDetailPopUp(
    cancelOnclick: () -> Unit,
    checkOnclick: () -> Unit,
) {
    MindWayAndroidTheme { colors, typography ->
        Column(
            verticalArrangement = Arrangement.spacedBy(28.dp, Alignment.CenterVertically),
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .height(152.dp)
                .background(
                    color = colors.WHITE,
                    shape = RoundedCornerShape(size = 8.dp)
                )
                .padding(
                    start = 24.dp,
                    top = 28.dp,
                    end = 24.dp,
                    bottom = 24.dp
                )
        ) {
            Row {
                Text(
                    text = stringResource(R.string.book),

                    style = typography.bodySmall,
                    fontWeight = FontWeight.Normal,
                    color = colors.Black,
                    modifier = Modifier.height(24.dp),
                )
                Spacer(modifier = Modifier.width(5.dp))
                Text(
                    text = stringResource(R.string.delete),

                    style = typography.bodySmall,
                    fontWeight = FontWeight.Normal,
                    color = colors.MAIN,
                    modifier = Modifier.height(24.dp),
                )
                Text(
                    text = stringResource(R.string.pr),

                    style = typography.bodySmall,
                    fontWeight = FontWeight.Normal,
                    color = colors.Black,
                    modifier = Modifier.height(24.dp),
                )
            }
            Row(
                horizontalArrangement = Arrangement.spacedBy(6.dp, Alignment.Start),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                MindWayButton(
                    modifier = Modifier
                        .weight(1f)
                        .padding(vertical = 12.dp), // TODO: modifier 위치이동 
                    text = stringResource(R.string.cancel),
                    onClick = cancelOnclick,
                    buttonColor = colors.GRAY600
                )
                MindWayButton(
                    modifier = Modifier
                        .weight(1f)
                        .padding(vertical = 12.dp),
                    text = stringResource(R.string.check),
                    onClick = checkOnclick
                )
            }
        }
    }
}

@Preview
@Composable
fun ViewDetailPopUpPreview() {
    ViewDetailPopUp(
        cancelOnclick = {},
        checkOnclick = {}
    )
}