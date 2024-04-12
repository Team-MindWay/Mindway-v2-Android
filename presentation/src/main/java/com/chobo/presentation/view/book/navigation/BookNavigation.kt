package com.chobo.presentation.view.book.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.chobo.presentation.view.book.screen.BookAddBookScreen
import com.chobo.presentation.view.book.screen.BookScreen

const val BookAddBookRoute = "book_add_book_route"

fun NavController.navigationToBookAddBook() {
    this.navigate(BookAddBookRoute)
}
fun NavGraphBuilder.bookAddBook(navigateToBack: () -> Boolean) {
    composable(BookAddBookRoute) {
        BookAddBookScreen()
    }
}
