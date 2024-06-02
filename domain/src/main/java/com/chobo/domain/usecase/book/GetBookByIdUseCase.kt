package com.chobo.domain.usecase.book

import com.chobo.domain.model.book.response.BookListResponseModel
import com.chobo.domain.repository.BookRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetBookByIdUseCase @Inject constructor(
    private val bookRepository: BookRepository,
) {
    suspend operator fun invoke(bookId: Long): Flow<BookListResponseModel> =
        bookRepository.bookGetById(bookId = bookId)

}
