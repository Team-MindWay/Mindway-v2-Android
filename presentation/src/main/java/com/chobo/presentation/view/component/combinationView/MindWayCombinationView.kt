package com.chobo.presentation.view.component.combinationView

import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.chobo.presentation.R
import com.chobo.presentation.view.book.screen.BookRoute
import com.chobo.presentation.view.component.bottom_navigation_bar.MindWayNavBar
import com.chobo.presentation.view.component.bottom_navigation_bar.MindWayNavBarItemType
import com.chobo.presentation.view.component.bottom_navigation_bar.MindWayNavBarItemType.BOOKS
import com.chobo.presentation.view.component.bottom_navigation_bar.MindWayNavBarItemType.EVENT
import com.chobo.presentation.view.component.bottom_navigation_bar.MindWayNavBarItemType.HOME
import com.chobo.presentation.view.component.bottom_navigation_bar.MindWayNavBarItemType.MY
import com.chobo.presentation.view.component.bottom_sheet.MindWayBottomSheet
import com.chobo.presentation.view.component.bottom_sheet.MindWayBottomSheetDialog
import com.chobo.presentation.view.event.screen.EventScreenRoute
import com.chobo.presentation.view.main.screen.HomeRoute
import com.chobo.presentation.view.my.screen.MyRoute
import com.chobo.presentation.viewModel.my.MyViewModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MindWayCombinationView(
    modifier: Modifier = Modifier,
    topDestination: MutableState<MindWayNavBarItemType>,
    myViewModel: MyViewModel = hiltViewModel(LocalContext.current as ComponentActivity),
    navigateToDetailEvent: () -> Unit,
    navigateToGoalReading: () -> Unit,
    navigateToBookAddBook: () -> Unit,
    navigateToIntro: () -> Unit,
    navigateToMyBookEdit: (Long) -> Unit,
    navigateToLogin: () -> Unit,
) {
    val coroutine = rememberCoroutineScope()
    val sheetState = rememberModalBottomSheetState(
        ModalBottomSheetValue.Hidden,
        skipHalfExpanded = true
    )

    MindWayBottomSheetDialog(
        sheetContent = {
            MindWayBottomSheet(
                topText = stringResource(R.string.mindway_intro),
                bottomText = stringResource(R.string.logout),
                topOnClick = navigateToIntro,
                bottomOnCLick = {
                    myViewModel.logout()
                    navigateToLogin()
                },
            )
        },
        sheetState = sheetState
    ) {
        Scaffold(
            bottomBar = {
                MindWayNavBar(
                    currentDestination = topDestination,
                    navigateToHome = { topDestination.value = HOME },
                    navigateToEvent = { topDestination.value = EVENT },
                    navigateToBooks = { topDestination.value = BOOKS },
                    navigateToMy = { topDestination.value = MY }
                )
            }
        ) { paddingValues ->
            Box(modifier = modifier.padding(paddingValues)) {
                when (topDestination.value) {
                    HOME -> HomeRoute(
                        navigateToGoalReading = navigateToGoalReading,
                        navigateToDetailEvent = navigateToDetailEvent,
                    )

                    EVENT -> EventScreenRoute(navigateToDetailEvent = navigateToDetailEvent)

                    BOOKS -> BookRoute(navigateToBookAddBook = navigateToBookAddBook)

                    MY -> MyRoute(
                        showSheet = { coroutine.launch { sheetState.show() } },
                        navigateToMyBookEdit = navigateToMyBookEdit,
                    )
                }
            }
        }
    }
}


@Preview
@Composable
fun MindWayCombinationViewPreview() {
    val topDestination = remember {
        mutableStateOf(HOME)
    }
    MindWayCombinationView(
        topDestination = topDestination,
        navigateToDetailEvent = { },
        navigateToGoalReading = { },
        navigateToBookAddBook = { },
        navigateToIntro = { },
        navigateToMyBookEdit = { },
        navigateToLogin = { }
    )
}