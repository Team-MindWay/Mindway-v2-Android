package com.chobo.data.repository

import com.chobo.data.remote.datasource.book.RemoteBookDataSource
import com.chobo.data.remote.dto.book.request.toDto
import com.chobo.data.remote.dto.book.response.toModel
import com.chobo.domain.model.book.request.BookRequestBodyModel
import com.chobo.domain.model.book.response.BookListResponseModel
import com.chobo.domain.repository.BookRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class BookRepositoryImpl @Inject constructor(
    private val bookDataSource: RemoteBookDataSource
) : BookRepository {
    override suspend fun bookPost(body: BookRequestBodyModel): Flow<Unit> {
        return bookDataSource.bookPost(body = body.toDto())
    }

    override suspend fun bookGet(): Flow<List<BookListResponseModel>> {
        return bookDataSource.bookGet().map { list -> list.map { it.toModel() } }
    }

    override suspend fun bookPatch(
        bookId: Long,
        body: BookRequestBodyModel
    ): Flow<Unit> {
        return bookDataSource.bookPatch(bookId = bookId, body = body.toDto())
    }

    override suspend fun bookDelete(bookId: Long): Flow<Unit> {
        return bookDataSource.bookDelete(bookId = bookId)
    }
}
