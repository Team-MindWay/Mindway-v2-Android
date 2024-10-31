package com.chobo.data.repository

import com.chobo.data.remote.datasource.book.RemoteBookDataSource
import com.chobo.data.remote.dto.book.request.toDto
import com.chobo.data.remote.dto.book.request.toModel
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
    override fun bookUpload(body: BookRequestBodyModel): Flow<Unit> =
        bookDataSource.bookUpload(body = body.toDto())

    override fun bookListGet(): Flow<List<BookListResponseModel>> =
        bookDataSource.bookListGet().map { list -> list.map { it.toModel() } }

    override fun bookGetById(bookId: Long): Flow<BookRequestBodyModel> =
        bookDataSource.bookGetById(bookId = bookId).map { it.toModel() }

    override fun bookModify(
        bookId: Long,
        body: BookRequestBodyModel
    ): Flow<Unit> =
        bookDataSource.bookModify(
            bookId = bookId,
            body = body.toDto()
        )

    override fun bookDeleteById(bookId: Long): Flow<Unit> =
        bookDataSource.bookDeleteById(bookId = bookId)
}
