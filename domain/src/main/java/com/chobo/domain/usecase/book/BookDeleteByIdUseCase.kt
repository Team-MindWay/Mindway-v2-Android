package com.chobo.domain.usecase.book

import com.chobo.domain.repository.BookRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class BookDeleteByIdUseCase @Inject constructor(
    private val bookRepository: BookRepository,
) {
    suspend operator fun invoke(bookId: Long): Flow<Unit> =
        bookRepository.bookDeleteById(bookId = bookId)
}