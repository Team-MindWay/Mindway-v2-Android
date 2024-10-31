package com.chobo.data.remote.datasource.book

import com.chobo.data.remote.dto.book.request.BookRequestBody
import com.chobo.data.remote.dto.book.response.BookListResponse
import kotlinx.coroutines.flow.Flow

interface RemoteBookDataSource {
     fun bookUpload(body: BookRequestBody): Flow<Unit>

     fun bookListGet(): Flow<List<BookListResponse>>

     fun bookGetById(bookId: Long): Flow<BookRequestBody>

     fun bookModify(
        body: BookRequestBody,
        bookId: Long
    ): Flow<Unit>

    fun bookDeleteById(bookId: Long): Flow<Unit>
}