package com.chobo.data.remote.datasource.book

import com.chobo.data.remote.dto.book.request.BookRequestBody
import com.chobo.data.remote.dto.book.response.BookListResponse
import kotlinx.coroutines.flow.Flow

interface RemoteBookDataSource {
    suspend fun bookUpload(body: BookRequestBody): Flow<Unit>

    suspend fun bookListGet(): Flow<List<BookListResponse>>

    suspend fun bookGetById(bookId: Long): Flow<BookListResponse>

    suspend fun bookModify(
        body: BookRequestBody,
        bookId: Long
    ): Flow<Unit>

    suspend fun bookDeleteById(bookId: Long): Flow<Unit>
}