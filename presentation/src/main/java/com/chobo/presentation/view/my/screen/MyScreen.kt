package com.chobo.presentation.view.my.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.lifecycle.viewmodel.compose.viewModel
import com.chobo.presentation.R
import com.chobo.presentation.view.my.component.MyBookDeletePopUp
import com.chobo.presentation.view.my.component.MyBookListItem
import com.chobo.presentation.view.my.component.MyNameCard
import com.chobo.presentation.view.theme.MindWayAndroidTheme
import com.chobo.presentation.viewModel.MyViewModel

@Composable
fun MyScreen(
    modifier: Modifier = Modifier,
    myViewModel: MyViewModel = viewModel(),
) {
    val myName by myViewModel.myName.collectAsState()
    val myBookListItemDataList by myViewModel.myBookListItemDataList.collectAsState()
    var bookDeleteDialog by remember { mutableStateOf(false) }
    var selectedIndex by remember { mutableStateOf(-1) }
    var selectedBookTitle by remember { mutableStateOf("") }

    MindWayAndroidTheme { colors, typography ->
        Column(modifier = modifier.background(color = colors.WHITE)) {

            if (bookDeleteDialog) {
                Dialog(onDismissRequest = { bookDeleteDialog = false },) {
                    MyBookDeletePopUp(
                        title = selectedBookTitle,
                        cancelOnclick = {
                            bookDeleteDialog = false
                            selectedBookTitle = ""
                        },
                        checkOnclick = {
                            if(selectedIndex != -1) {
                                myViewModel.removeBookItem(selectedIndex)
                                selectedIndex = -1
                            }
                            bookDeleteDialog = false
                            selectedBookTitle = ""
                        }
                    )
                }
            }

            Column(modifier = modifier.background(color = colors.WHITE)) {
                Spacer(modifier = Modifier.height(43.dp))
                MyNameCard(
                    name = myName,
                    onClick = { myViewModel.optionOnClick() },
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
                        .padding(horizontal = 24.dp)
                ) {
                    itemsIndexed(myBookListItemDataList) { index, item ->
                        MyBookListItem(
                            title = item.title,
                            writer = item.writer,
                            editOnclick = { item.editOnclick },
                            trashCanOnclick = {
                                item.trashCanOnclick
                                bookDeleteDialog = true
                                selectedIndex = index
                                selectedBookTitle = item.title
                            }
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MyScreenPreview() {
    MyScreen()
}