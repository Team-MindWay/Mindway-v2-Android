package com.chobo.domain.repository

import com.chobo.domain.model.book.request.BookRequestBodyModel
import com.chobo.domain.model.book.response.BookListResponseModel
import kotlinx.coroutines.flow.Flow

interface BookRepository {
    suspend fun bookPost(body: BookRequestBodyModel): Flow<Unit>
    suspend fun bookGet(): Flow<List<BookListResponseModel>>

    suspend fun bookPatch(
        bookId: Long,
        bookRequestBodyModel: BookRequestBodyModel
    ): Flow<Unit>

    suspend fun bookDelete(bookId: Long): Flow<Unit>
}