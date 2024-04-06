package com.chobo.presentation.view.my.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chobo.presentation.R
import com.chobo.presentation.view.main.screen.MockOnClick
import com.chobo.presentation.view.my.component.MyBookListItem
import com.chobo.presentation.view.my.component.MyBookListItemData
import com.chobo.presentation.view.my.component.MyNameCard
import com.chobo.presentation.view.theme.MindWayAndroidTheme

@Composable
fun MyScreen(
    name: String,
    myNameOnClick: () -> Unit,
    myBookListItemDataList: List<MyBookListItemData>,
) {
    MindWayAndroidTheme { colors, typography ->
        Column {
            Spacer(modifier = Modifier.height(43.dp))
            MyNameCard(name = name,
                onClick = { myNameOnClick() }
            )
            Row(
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(horizontal = 24.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    text = stringResource(R.string.book_request_list),
                    style = typography.labelLarge,
                    fontWeight = FontWeight.Normal,
                    color = colors.GRAY400,
                )
            }
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(20.dp, Alignment.Top),
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        horizontal = 24.dp,
                        vertical = 16.dp
                    )
            ) {
                items(myBookListItemDataList) {
                    MyBookListItem(
                        title = it.title,
                        writer = it.writer,
                        editOnclick = { it.editOnclick },
                        trashCanOnclick = { it.trashCanOnclick }
                    )
                }
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun MyScreenPreview() {
    MyScreen(
        name = "한제형",
        myNameOnClick = { MockOnClick() },
        myBookListItemDataList = listOf(
            MyBookListItemData(title = "제목입니다", writer = "작가입니다", editOnclick = { MockOnClick() }, trashCanOnclick = { MockOnClick() }),
            MyBookListItemData(title = "dqwdqwd", writer = "작가입니다", editOnclick = { MockOnClick() }, trashCanOnclick = { MockOnClick() }),
            MyBookListItemData(title = "제목입니다", writer = "작가입니다", editOnclick = { MockOnClick() }, trashCanOnclick = { MockOnClick() }),
            MyBookListItemData(title = "제목입dqwdqw니다", writer = "작dqw가입니다", editOnclick = { MockOnClick() }, trashCanOnclick = { MockOnClick() }),
            MyBookListItemData(title = "제목입니다", writer = "작가입dqw니다", editOnclick = { MockOnClick() }, trashCanOnclick = { MockOnClick() }),
            MyBookListItemData(title = "제목입니다", writer = "작가입니다", editOnclick = { MockOnClick() }, trashCanOnclick = { MockOnClick() }),
            MyBookListItemData(title = "dwq", writer = "작가입니다", editOnclick = { MockOnClick() }, trashCanOnclick = { MockOnClick() }),
            MyBookListItemData(title = "제목입니다", writer = "작가입dqwd니다", editOnclick = { MockOnClick() }, trashCanOnclick = { MockOnClick() }),
            MyBookListItemData(title = "제목입니다", writer = "작가입니다", editOnclick = { MockOnClick() }, trashCanOnclick = { MockOnClick() }),
            MyBookListItemData(title = "제목입dqwdqw니다", writer = "작가dqwdqw입니다", editOnclick = { MockOnClick() }, trashCanOnclick = { MockOnClick() }),
            MyBookListItemData(title = "제목입dqwd니다", writer = "작가입dqwdwq다", editOnclick = { MockOnClick() }, trashCanOnclick = { MockOnClick() }),


        )
    )
}