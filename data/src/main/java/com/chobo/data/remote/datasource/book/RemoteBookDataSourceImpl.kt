package com.chobo.data.remote.datasource.book

import com.chobo.data.remote.api.BookAPI
import com.chobo.data.remote.dto.book.request.BookRequestBody
import com.chobo.data.remote.dto.book.response.BookListResponse
import com.chobo.data.util.performApiRequest
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RemoteBookDataSourceImpl @Inject constructor(
    private val bookService: BookAPI
) : RemoteBookDataSource {
    override fun bookUpload(body: BookRequestBody): Flow<Unit> =
        performApiRequest { bookService.bookUpload(body = body) }

    override fun bookListGet(): Flow<List<BookListResponse>> =
        performApiRequest { bookService.bookListGet() }

    override fun bookGetById(bookId: Long): Flow<BookRequestBody> =
        performApiRequest { bookService.bookGetById(bookId = bookId) }

    override fun bookModify(
        body: BookRequestBody,
        bookId: Long
    ): Flow<Unit> =
        performApiRequest { bookService.bookModify(
            body = body,
            bookId = bookId
        ) }

    override fun bookDeleteById(bookId: Long): Flow<Unit> =
        performApiRequest { bookService.bookDeleteById(bookId = bookId) }
}