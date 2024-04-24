package com.chobo.presentation.view.login.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chobo.presentation.R
import com.chobo.presentation.view.component.multipleEventsCutterManager.clickableSingle
import com.chobo.presentation.view.theme.MindWayAndroidTheme
import com.chobo.presentation.view.theme.color.MindWayColor

@Composable
fun MindWayGAuthButton(
    modifier: Modifier = Modifier,
    buttonColor: Color = MindWayColor.WHITE,
    onClick: () -> Unit
) {
    MindWayAndroidTheme { colors, _ ->
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally),
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .fillMaxWidth()
                .background(
                    color = buttonColor,
                    shape = RoundedCornerShape(size = 8.dp)
                )
                .border(
                    width = 1.dp,
                    colors.MAIN,
                    shape = RoundedCornerShape(size = 8.dp)
                )
                .clickableSingle { onClick() }
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_mindway_gauth),
                contentDescription = "MindWay_GAuth_Img",
                contentScale = ContentScale.None
            )
            Image(
                painter = painterResource(id = R.drawable.ic_mindway_gauth_string),
                contentDescription = "MindWay_GAuth_String_Img",
                contentScale = ContentScale.None
            )
        }
    }
}

@Preview
@Composable
fun MindWayGAuthButtonPreview() {
    MindWayGAuthButton {}
}