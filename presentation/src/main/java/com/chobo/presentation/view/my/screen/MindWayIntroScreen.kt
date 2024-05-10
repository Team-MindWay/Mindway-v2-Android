package com.chobo.presentation.view.my.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
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
import com.chobo.presentation.view.my.component.MindWayIntroTopAppBar
import com.chobo.presentation.view.theme.MindWayAndroidTheme

@Composable
internal fun MindWayIntroRoute(
    modifier: Modifier = Modifier,
    navigateToBack: () -> Unit
) {
    MindWayIntroScreen (
        modifier = modifier,
        navigateToBack = navigateToBack
    )
}

@Composable
internal fun MindWayIntroScreen(
    modifier: Modifier = Modifier,
    navigateToBack: () -> Unit
) {
    MindWayAndroidTheme { colors, typography ->
        Column(modifier = modifier.background(color = colors.WHITE)) {
            MindWayIntroTopAppBar(startIconOnClick = { navigateToBack() })
            Box(modifier = Modifier.fillMaxSize()) {
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
                            color = colors.Black,
                        )
                        Text(
                            text = stringResource(R.string.mindway_intro2),
                            style = typography.bodyLarge,
                            fontWeight = FontWeight.SemiBold,
                            color = colors.Black,
                        )
                    }
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 20.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.image_book),
                            contentDescription = "MindWay_book",
                            modifier = Modifier.align(Alignment.Center)
                        )
                        Text(
                            text = stringResource(R.string.mindway_intro3),
                            style = TextStyle(
                                fontSize = 16.sp,
                                lineHeight = 32.sp,
                                fontFamily = FontFamily(Font(R.font.pretendard)),
                                fontWeight = FontWeight.Normal,
                                color = colors.Black,
                                textAlign = TextAlign.Center,
                            )
                        )
                    }
                    Spacer(modifier = Modifier.weight(2f))
                    Text(
                        text = stringResource(R.string.copyright),
                        style = typography.labelLarge,
                        fontWeight = FontWeight.Normal,
                        color = colors.GRAY400,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.weight(0.3f))
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MindWayIntroScreenPreview() {
    MindWayIntroScreen(navigateToBack = {})
}
