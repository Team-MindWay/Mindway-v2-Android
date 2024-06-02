package com.chobo.data.repository

import com.chobo.data.remote.datasource.book.RemoteBookDataSource
import com.chobo.data.remote.dto.book.request.toDto
import com.chobo.data.remote.dto.book.request.toModel
import com.chobo.data.remote.dto.book.response.toModel
import com.chobo.domain.model.book.request.BookRequestBodyModel
import com.chobo.domain.model.book.response.BookListResponseModel
import com.chobo.domain.repository.BookRepository
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class BookRepositoryImpl @Inject constructor(
    private val bookDataSource: RemoteBookDataSource
) : BookRepository {
    override suspend fun bookUpload(body: BookRequestBodyModel): Flow<Unit> {
        return bookDataSource.bookUpload(body = body.toDto())
    }

    override suspend fun bookListGet(): Flow<List<BookListResponseModel>> {
        return bookDataSource.bookListGet().map { list -> list.map { it.toModel() } }
    }

    override suspend fun bookGetById(bookId: Long): Flow<BookRequestBodyModel> {
        return bookDataSource.bookGetById(bookId = bookId).map { it.toModel() }
    }

    override suspend fun bookModify(
        bookId: Long,
        body: BookRequestBodyModel
    ): Flow<Unit> {
        return bookDataSource.bookModify(bookId = bookId, body = body.toDto())
    }

    override suspend fun bookDeleteById(bookId: Long): Flow<Unit> {
        return bookDataSource.bookDeleteById(bookId = bookId)
    }
}
