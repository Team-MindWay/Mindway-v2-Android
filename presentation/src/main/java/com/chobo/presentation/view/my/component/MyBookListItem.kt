package com.chobo.presentation.view.my.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chobo.presentation.view.component.icon.EditIcon
import com.chobo.presentation.view.component.icon.TrashCanIcon
import com.chobo.presentation.view.component.multipleEventsCutterManager.clickableSingle
import com.chobo.presentation.view.theme.MindWayAndroidTheme

data class MyBookListItemData(
    val title: String,
    val writer: String,
    val trashCanOnclick: () -> Unit,
)

@Composable
fun MyBookListItem(
    title: String,
    writer: String,
    editOnclick: () -> Unit,
    trashCanOnclick: () -> Unit,
) {
    MindWayAndroidTheme { colors, typography ->
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .shadow(
                    elevation = 20.dp,
                    spotColor = colors.CardShadow,
                    ambientColor = colors.CardShadow
                )
                .fillMaxWidth()
                .background(
                    color = colors.WHITE,
                    shape = RoundedCornerShape(size = 8.dp)
                )
                .padding(
                    horizontal = 16.dp,
                    vertical = 20.dp
                )
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(4.dp, Alignment.CenterVertically),
                horizontalAlignment = Alignment.Start,
            ) {
                Text(
                    text = title,
                    style = typography.bodyMedium,
                    fontWeight = FontWeight.Normal,
                    color = colors.Black,
                )
                Text(
                    text = writer,
                    style = typography.labelLarge,
                    fontWeight = FontWeight.Normal,
                    color = colors.GRAY500,
                )
            }
            Row(
                horizontalArrangement = Arrangement.spacedBy(28.dp, Alignment.Start),
                verticalAlignment = Alignment.Top,
            ) {
                EditIcon(
                    modifier = Modifier.clickableSingle(onClick = editOnclick)
                )
                TrashCanIcon(
                    modifier = Modifier.clickableSingle(onClick = trashCanOnclick)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MyBookListItemPreview() {
    MyBookListItem(
        title = "제목",
        writer = "저자",
        editOnclick = { },
        trashCanOnclick = { })
}