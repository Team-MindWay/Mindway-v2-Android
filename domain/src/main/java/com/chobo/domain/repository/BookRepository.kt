package com.chobo.domain.repository

import com.chobo.domain.model.book.request.BookRequestBodyModel
import com.chobo.domain.model.book.response.BookListResponseModel
import kotlinx.coroutines.flow.Flow

interface BookRepository {
    suspend fun bookPost(body: BookRequestBodyModel): Flow<Unit>
    suspend fun bookListGet(): Flow<List<BookListResponseModel>>
    suspend fun bookGet(bookId: Long): Flow<BookListResponseModel>
    suspend fun bookPatch(
        bookId: Long,
        body: BookRequestBodyModel
    ): Flow<Unit>
    suspend fun bookDelete(bookId: Long): Flow<Unit>
}