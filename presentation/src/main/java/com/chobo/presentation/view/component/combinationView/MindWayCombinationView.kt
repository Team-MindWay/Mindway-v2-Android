package com.chobo.presentation.view.component.combinationView

import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
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
    myViewModel: MyViewModel = hiltViewModel(LocalContext.current as ComponentActivity),
    currentDestination: MindWayNavBarItemType,
    setCurrentDestination: (MindWayNavBarItemType) -> Unit,
    navigateToDetailEvent: (Long) -> Unit,
    navigateToGoalReading: () -> Unit,
    navigateToBookAddBook: () -> Unit,
    navigateToIntro: () -> Unit,
    navigateToMyBookEdit: () -> Unit,
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
                    currentDestination = currentDestination,
                    setCurrentDestination = setCurrentDestination,
                )
            }
        ) { paddingValues ->
            Box(modifier = modifier.padding(paddingValues)) {
                when (currentDestination) {
                    HOME -> HomeRoute(navigateToGoalReading = navigateToGoalReading)
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
    val topDestination by remember {
        mutableStateOf(HOME)
    }
    MindWayCombinationView(
        currentDestination = topDestination,
        navigateToDetailEvent = { },
        navigateToGoalReading = { },
        navigateToBookAddBook = { },
        navigateToIntro = { },
        navigateToMyBookEdit = { },
        navigateToLogin = { },
        setCurrentDestination = { },
    )
}