package com.chobo.data.remote.datasource.book

import com.chobo.data.remote.dto.book.request.BookRequestBody
import com.chobo.data.remote.dto.book.response.BookListResponse
import kotlinx.coroutines.flow.Flow

interface RemoteBookDataSource {
    suspend fun bookPost(body: BookRequestBody): Flow<Unit>

    suspend fun bookListGet(): Flow<List<BookListResponse>>

    suspend fun bookPatch(
        body: BookRequestBody,
        bookId: Long
    ): Flow<Unit>

    suspend fun bookDelete(bookId: Long): Flow<Unit>
}