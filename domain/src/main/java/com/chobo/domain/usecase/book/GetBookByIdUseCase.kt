package com.chobo.domain.usecase.book

import com.chobo.domain.model.book.request.BookRequestBodyModel
import com.chobo.domain.repository.BookRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetBookByIdUseCase @Inject constructor(
    private val bookRepository: BookRepository,
) {
bbb     operator fun invoke(bookId: Long): Flow<BookRequestBodyModel> =
        bookRepository.bookGetById(bookId = bookId)
}
