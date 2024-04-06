package com.chobo.presentation.view.my.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.chobo.presentation.R
import com.chobo.presentation.view.theme.MindWayAndroidTheme

@Composable
fun MindWayIntroScreen() {
    MindWayAndroidTheme { colors, typography ->
        Column {
            Column(
                verticalArrangement = Arrangement.spacedBy(12.dp, Alignment.Top),
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        top = 48.dp,
                        bottom = 28.dp
                    )
            ) {
                Text(
                    text = stringResource(R.string.mindway_intro1),
                    style = typography.bodySmall,
                    fontWeight = FontWeight.Normal,
                    color = Color(0xFF000000),
                )
                Text(
                    text = stringResource(R.string.mindway_intro2),
                    style = typography.bodyLarge,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(0xFF000000),
                )
            }
            Row(
                horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterHorizontally),
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 20.dp)
            ) {
                Text(
                    text = stringResource(R.string.mindway_intro3),
                    style = TextStyle(
                        fontSize = 16.sp,
                        lineHeight = 32.sp,
                        fontFamily = FontFamily(Font(R.font.pretendard)),
                        fontWeight = FontWeight.Normal,
                        color = Color(0xFF000000),
                        textAlign = TextAlign.Center,
                    )
                )
            }
            Spacer(modifier = Modifier.weight(2f))
            Text(
                text = stringResource(R.string.copyright),
                style = typography.labelLarge, fontWeight = FontWeight(400),
                color = colors.GRAY400,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.weight(0.3f))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MindWayIntroScreenPreview() {
    MindWayIntroScreen()
}