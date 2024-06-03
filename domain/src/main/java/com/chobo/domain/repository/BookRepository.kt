package com.chobo.domain.repository

import com.chobo.domain.model.book.request.BookRequestBodyModel
import com.chobo.domain.model.book.response.BookListResponseModel
import kotlinx.coroutines.flow.Flow

interface BookRepository {
    suspend fun bookUpload(body: BookRequestBodyModel): Flow<Unit>
    suspend fun bookListGet(): Flow<List<BookListResponseModel>>
    suspend fun bookGetById(bookId: Long): Flow<BookListResponseModel>
    suspend fun bookModify(bookId: Long, body: BookRequestBodyModel): Flow<Unit>
    suspend fun bookDeleteById(bookId: Long): Flow<Unit>
}