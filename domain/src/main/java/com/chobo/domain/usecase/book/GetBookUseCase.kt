package com.chobo.domain.usecase.book

import com.chobo.domain.repository.BookRepository
import javax.inject.Inject

class GetBookUseCase @Inject constructor(
    private val bookRepository: BookRepository
) {
    suspend operator fun invoke() = runCatching {
        bookRepository.bookGet()
    }
}