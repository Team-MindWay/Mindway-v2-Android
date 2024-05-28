package com.chobo.presentation.view.my.screen

import androidx.activity.ComponentActivity
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.chobo.presentation.R
import com.chobo.presentation.view.component.bottom_sheet.MindWayBottomSheet
import com.chobo.presentation.view.component.bottom_sheet.MindWayBottomSheetDialog
import com.chobo.presentation.view.component.customToast.MindWayToast
import com.chobo.presentation.view.my.component.MyBookDeletePopUp
import com.chobo.presentation.view.my.component.MyBookListItem
import com.chobo.presentation.view.my.component.MyBookListItemData
import com.chobo.presentation.view.my.component.MyNameCard
import com.chobo.presentation.view.theme.MindWayAndroidTheme
import com.chobo.presentation.viewModel.my.MyViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
internal fun MyRoute(
    modifier: Modifier = Modifier,
    myViewModel: MyViewModel = hiltViewModel(LocalContext.current as ComponentActivity),
    navigateToMyBookEdit: () -> Unit,
    navigateToIntro: () -> Unit,
    navigateToLogin: () -> Unit,
) {
    val myName by myViewModel.myName.collectAsStateWithLifecycle()
    val myBookListItemDataList by myViewModel.myBookListItemDataList.collectAsStateWithLifecycle()
    val isToastVisible by myViewModel.isToastVisible.collectAsStateWithLifecycle()
    val selectedBookTitle by myViewModel.selectedBookTitle.collectAsStateWithLifecycle()
    val bookDeleteDialogIsVisible by myViewModel.bookDeleteDialogIsVisible.collectAsStateWithLifecycle()
    val selectedIndex by myViewModel.selectedIndex.collectAsStateWithLifecycle()

    MyScreen(
        modifier = modifier,
        myName = myName,
        myBookListItemDataList = myBookListItemDataList,
        isToastVisible = isToastVisible,
        selectedBookTitle = selectedBookTitle,
        bookDeleteDialogIsVisible = bookDeleteDialogIsVisible,
        selectedIndex = selectedIndex,
        toggleBookDeleteDialogIsVisible = myViewModel::toggleBookDeleteDialogIsVisible,
        setSelectedIndex = myViewModel::setSelectedIndex,
        editBookOnClick = myViewModel::editBookOnClick,
        logout = myViewModel::logout,
        navigateToIntro = navigateToIntro,
        navigateToLogin = navigateToLogin,
        navigateToMyBookEdit = navigateToMyBookEdit,
    )
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MyScreen(
    modifier: Modifier = Modifier,
    myName: String,
    myBookListItemDataList: List<MyBookListItemData>,
    isToastVisible: Boolean,
    selectedBookTitle: String,
    bookDeleteDialogIsVisible: Boolean,
    selectedIndex: Int,
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
    toggleBookDeleteDialogIsVisible: () -> Unit,
    setSelectedIndex: (Int) -> Unit,
    editBookOnClick: (Int) -> Unit,
    logout: () -> Unit,
    navigateToIntro: () -> Unit,
    navigateToLogin: () -> Unit,
    navigateToMyBookEdit: () -> Unit,
) {
    MindWayAndroidTheme { colors, typography ->
        MindWayBottomSheetDialog(
            sheetContent = {
                MindWayBottomSheet(
                    topText = stringResource(R.string.mindway_intro),
                    bottomText = stringResource(R.string.logout),
                    topOnClick = navigateToIntro,
                    bottomOnCLick = {
                        logout()
                        navigateToLogin()
                    },
                )
            }
        ) { sheetState ->
            Box(modifier = modifier.background(color = colors.WHITE)) {
                Column {
                    if (bookDeleteDialogIsVisible) {
                        Dialog(onDismissRequest = toggleBookDeleteDialogIsVisible) {
                            MyBookDeletePopUp(
                                title = selectedBookTitle,
                                cancelOnclick = toggleBookDeleteDialogIsVisible,
                                checkOnclick = {
                                    if (selectedIndex != -1)
                                        setSelectedIndex(-1)
                                    toggleBookDeleteDialogIsVisible()
                                }
                            )
                        }
                    }
                    MyNameCard(
                        name = myName,
                        onClick = { coroutineScope.launch { sheetState.show() } },
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
                        itemsIndexed(myBookListItemDataList) { index, item ->
                            MyBookListItem(
                                title = item.title,
                                writer = item.writer,
                                editOnclick = {
                                    editBookOnClick(index)
                                    navigateToMyBookEdit()
                                },
                                trashCanOnclick = {
                                    item.trashCanOnclick
                                    toggleBookDeleteDialogIsVisible()
                                    setSelectedIndex(index)
                                }
                            )
                        }
                    }
                }
                AnimatedVisibility(
                    visible = isToastVisible,
                    enter = slideInVertically(
                        initialOffsetY = { it + 110 },
                        animationSpec = tween(durationMillis = 500)
                    ),
                    exit = slideOutVertically(
                        targetOffsetY = { it + 110 },
                        animationSpec = tween(durationMillis = 500)
                    ),
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .offset(y = (-50).dp)
                        .padding(horizontal = 24.dp),
                ) {
                    MindWayToast(
                        isSuccess = true,
                        text = stringResource(R.string.book_request_succes_toast),
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MyScreenPreview() {
    MyRoute(
        navigateToMyBookEdit = { },
        navigateToIntro = { },
        navigateToLogin = { }
    )
}