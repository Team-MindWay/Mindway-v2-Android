package com.chobo.presentation.view.book.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.chobo.presentation.view.book.screen.BookAddBookScreen
import com.chobo.presentation.view.book.screen.BookScreen

const val BookAddBookRoute = "book_add_book_route"
const val BookRoute = "book_route"

fun NavController.navigationToBookAddBook() {
    this.navigate(BookAddBookRoute)
}

fun NavController.navigationToBook() {
    this.navigate(BookRoute)
}


fun NavGraphBuilder.bookAddBook(navigateToBack: () -> Boolean) {
    composable(BookAddBookRoute) {
        BookAddBookScreen()
    }
}

fun NavGraphBuilder.book(navigateToBookAddBook: () -> Unit, navigateToHomeViewDetail: () -> Unit) {
    composable(BookRoute) {
        BookScreen()
    }
}