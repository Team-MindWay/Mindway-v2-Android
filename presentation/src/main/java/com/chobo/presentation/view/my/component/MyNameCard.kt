package com.chobo.presentation.view.my.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chobo.presentation.R
import com.chobo.presentation.view.component.icon.OptionIcon
import com.chobo.presentation.view.component.multipleEventsCutterManager.clickableSingle
import com.chobo.presentation.view.theme.MindWayAndroidTheme

@Composable
fun MyNameCard(
    name: String,
    onClick: () -> Unit
) {
    MindWayAndroidTheme { colors, typography ->
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Top,
            modifier = Modifier
                .fillMaxWidth()
                .background(color = colors.GRAY100)
                .padding(
                    vertical = 24.dp,
                    horizontal = 40.dp
                )
        ) {
            Column {
                Text(
                    text = stringResource(R.string.greeting),
                    style = typography.headlineSmall,
                    fontWeight = FontWeight.Normal,
                    color = colors.Black,
                )
                Row {
                    Text(
                        text = name,
                        style = typography.headlineSmall,
                        fontWeight = FontWeight.SemiBold,
                        color = colors.Black,
                    )
                    Text(
                        text = stringResource(R.string.sir),
                        style = typography.headlineSmall,
                        fontWeight = FontWeight.SemiBold,
                        color = colors.MAIN,
                    )
                }
            }
            OptionIcon(
                modifier = Modifier.clickableSingle { onClick() }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MyNameCardPreview() {
    MyNameCard(
        name = "함제형",
        onClick = { }
    )
}