package com.chobo.domain.usecase.book

import com.chobo.domain.repository.BookRepository
import javax.inject.Inject

class BookGetByIdUseCase @Inject constructor(
    private val bookRepository: BookRepository
) {
    suspend operator fun invoke(bookId: Long) = runCatching {
        bookRepository.bookGetById(bookId = bookId)
    }
}
