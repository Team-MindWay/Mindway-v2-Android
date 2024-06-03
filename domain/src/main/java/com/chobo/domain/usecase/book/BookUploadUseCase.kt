package com.chobo.domain.usecase.book

import com.chobo.domain.model.book.request.BookRequestBodyModel
import com.chobo.domain.repository.BookRepository
import javax.inject.Inject

class BookUploadUseCase @Inject constructor(
    private val bookRepository: BookRepository
) {
    suspend operator fun invoke(body: BookRequestBodyModel) = runCatching {
        bookRepository.bookUpload(body = body)
    }
}