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
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import com.chobo.domain.model.my.MyBookListModel
import com.chobo.presentation.R
import com.chobo.presentation.view.component.customToast.MindWayToast
import com.chobo.presentation.view.component.icon.BookImage
import com.chobo.presentation.view.my.component.MyBookDeletePopUp
import com.chobo.presentation.view.my.component.MyBookListItem
import com.chobo.presentation.view.my.component.MyNameCard
import com.chobo.presentation.view.theme.MindWayAndroidTheme
import com.chobo.presentation.viewModel.my.MyViewModel
import com.chobo.presentation.viewModel.my.UiState.GetMyBookListUiState
import com.chobo.presentation.viewModel.my.UiState.GetMyInformationUiState

@Composable
internal fun MyRoute(
    modifier: Modifier = Modifier,
    myViewModel: MyViewModel = hiltViewModel(LocalContext.current as ComponentActivity),
    showSheet: () -> Unit,
    navigateToMyBookEdit: (Long) -> Unit,
) {
    val myNameUiState by myViewModel.getMyInformationUiState.collectAsStateWithLifecycle()
    val getMyBookListUiState by myViewModel.getMyBookListUiState.collectAsStateWithLifecycle()
    val isCommunicationSuccess by myViewModel.isCommunicationSuccess.collectAsStateWithLifecycle()
    val isToastVisible by myViewModel.isToastVisible.collectAsStateWithLifecycle()

    MyScreen(
        modifier = modifier,
        myNameUiState = myNameUiState,
        getMyBookListUiState = getMyBookListUiState,
        isCommunicationSuccess = isCommunicationSuccess,
        isToastVisible = isToastVisible,
        orderDeleteById = myViewModel::orderDeleteById,
        setBook = myViewModel::setBook,
        showSheet = showSheet,
        navigateToMyBookEdit = navigateToMyBookEdit,
    )
}

@Composable
fun MyScreen(
    modifier: Modifier = Modifier,
    myNameUiState: GetMyInformationUiState,
    getMyBookListUiState: GetMyBookListUiState,
    isCommunicationSuccess: Boolean,
    isToastVisible: Boolean,
    orderDeleteById: (Long) -> Unit,
    setBook: (MyBookListModel) -> Unit,
    showSheet: () -> Unit,
    navigateToMyBookEdit: (Long) -> Unit,
) {
    val (bookDeleteDialogIsVisible, setBookDeleteDialogIsVisible) = remember { mutableStateOf(false) }
    val (selectedBookTitle, setSelectedBookTitle) = remember { mutableStateOf("") }
    val (selectedIndex, setSelectedIndex) = remember { mutableLongStateOf(0L) }

    MindWayAndroidTheme { colors, typography ->
        Box(modifier = modifier.background(color = colors.WHITE)) {
            Column(modifier = modifier.fillMaxSize()) {
                if (bookDeleteDialogIsVisible) {
                    Dialog(onDismissRequest = { setBookDeleteDialogIsVisible(false) }) {
                        MyBookDeletePopUp(
                            title = selectedBookTitle,
                            cancelOnclick = { setBookDeleteDialogIsVisible(false) },
                            checkOnclick = {
                                orderDeleteById(selectedIndex)
                                setBookDeleteDialogIsVisible(false)
                            }
                        )
                    }
                }
                MyNameCard(
                    name = when (myNameUiState) {
                        is GetMyInformationUiState.Fail -> ""
                        is GetMyInformationUiState.Loading -> ""
                        is GetMyInformationUiState.Success -> myNameUiState.data.name
                    },
                    onClick = showSheet,
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
                when (getMyBookListUiState) {
                    is GetMyBookListUiState.Empty -> {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            Column(
                                verticalArrangement = Arrangement.spacedBy(20.dp, Alignment.Top),
                                horizontalAlignment = Alignment.CenterHorizontally,
                            ) {
                                BookImage()
                                Text(
                                    text = stringResource(R.string.is_no_past_event),
                                    style = typography.bodyMedium,
                                    fontWeight = FontWeight.Normal,
                                    color = colors.GRAY500,
                                )
                            }
                        }
                    }

                    is GetMyBookListUiState.Fail -> {}
                    is GetMyBookListUiState.Loading -> {}
                    is GetMyBookListUiState.Success -> {
                        LazyColumn(
                            verticalArrangement = Arrangement.spacedBy(20.dp, Alignment.Top),
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(
                                    horizontal = 24.dp,
                                    vertical = 16.dp
                                )
                        ) {
                            items(getMyBookListUiState.data) { item ->
                                MyBookListItem(
                                    title = item.title,
                                    writer = item.author,
                                    editOnclick = {
                                        navigateToMyBookEdit(item.id)
                                        setBook(item)
                                    },
                                    trashCanOnclick = {
                                        setSelectedIndex(item.id)
                                        setSelectedBookTitle(item.title)
                                        setBookDeleteDialogIsVisible(true)
                                    }
                                )
                            }
                        }
                    }
                }
            }
            if (isCommunicationSuccess) {
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
                        isSuccess = false,
                        text = stringResource(R.string.order_delete_fail),
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            } else {
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
                        text = stringResource(R.string.order_delete_success),
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
        navigateToMyBookEdit = {},
        showSheet = {}
    )
}