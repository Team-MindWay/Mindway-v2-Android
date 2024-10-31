package com.chobo.domain.usecase.book

import com.chobo.domain.model.book.response.BookListResponseModel
import com.chobo.domain.repository.BookRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetBookListUseCase @Inject constructor(
    private val bookRepository: BookRepository,
) {
    operator fun invoke(): Flow<List<BookListResponseModel>> =
        bookRepository.bookListGet()
}