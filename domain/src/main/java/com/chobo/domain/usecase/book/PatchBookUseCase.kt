package com.chobo.domain.usecase.book

import com.chobo.domain.model.book.request.BookRequestBodyModel
import com.chobo.domain.repository.BookRepository
import javax.inject.Inject

class PatchBookUseCase @Inject constructor(
    private val bookRepository: BookRepository
) {
    suspend operator fun invoke(bookId: Long, bookRequestBodyModel: BookRequestBodyModel) =
        runCatching {
            bookRepository.bookPatch(
                bookId = bookId,
                body = bookRequestBodyModel
            )
        }
}