package com.chobo.domain.usecase.book

import com.chobo.domain.model.book.request.BookRequestBodyModel
import com.chobo.domain.repository.BookRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class BookModifyUseCase @Inject constructor(
    private val bookRepository: BookRepository,
) {
    operator fun invoke(bookId: Long, bookRequestBodyModel: BookRequestBodyModel): Flow<Unit> =
        bookRepository.bookModify(
            bookId = bookId,
            body = bookRequestBodyModel
        )
}