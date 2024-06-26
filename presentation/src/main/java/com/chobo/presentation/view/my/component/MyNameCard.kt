package com.chobo.presentation.view.my.component

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
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

@Stable
@Composable
fun MyNameCard(
    modifier: Modifier = Modifier,
    name: String,
    onClick: () -> Unit
) {
    MindWayAndroidTheme { colors, typography ->
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Top,
            modifier = modifier
                .fillMaxWidth()
                .padding(
                    top = 60.dp,
                    start = 24.dp,
                    end = 24.dp,
                    bottom = 40.dp
                )
        ) {
            Column(
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.Start,
            ) {
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
            OptionIcon(modifier = Modifier.clickableSingle(onClick = onClick))
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