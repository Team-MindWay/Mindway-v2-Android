package com.chobo.presentation.view.component.compostionView

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.chobo.presentation.view.book.screen.BookScreen
import com.chobo.presentation.view.component.bottom_navigation_bar.MindWayNavBarItemType.*
import com.chobo.presentation.view.component.scaffold.MindWayScaffold
import com.chobo.presentation.view.event.screen.EventScreen
import com.chobo.presentation.view.main.screen.HomeScreen
import com.chobo.presentation.view.my.screen.MyScreen

@Composable
fun MindWayCombinationView(){
    val topDestination = remember {
        mutableStateOf(HOME)
    }
    MindWayScaffold(currentDestination = topDestination) {
        when(topDestination.value){
            HOME -> HomeScreen(navigateToGoalReading = { /*TODO*/ }) {}
            EVENT -> EventScreen(navigateToDetailEvent = { /*TODO*/ })
            BOOKS -> BookScreen()
            MY -> MyScreen()
        }
    }
}