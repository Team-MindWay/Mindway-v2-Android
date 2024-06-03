package com.chobo.data.remote.datasource.book

import com.chobo.data.remote.api.BookAPI
import com.chobo.data.remote.dto.book.request.BookRequestBody
import com.chobo.data.remote.dto.book.response.BookListResponse
import com.chobo.data.util.MindWayAPIHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class RemoteBookDataSourceImpl @Inject constructor(
    private val bookAPI: BookAPI
) : RemoteBookDataSource {
    override suspend fun bookUpload(body: BookRequestBody): Flow<Unit> = flow {
        emit(
            MindWayAPIHandler<Unit>()
                .httpRequest { bookAPI.bookUpload(body = body) }
                .sendRequest()
        )
    }.flowOn(Dispatchers.IO)

    override suspend fun bookListGet(): Flow<List<BookListResponse>> = flow {
        emit(
            MindWayAPIHandler<List<BookListResponse>>()
                .httpRequest { bookAPI.bookListGet() }
                .sendRequest()
        )
    }.flowOn(Dispatchers.IO)


    override suspend fun bookGetById(
        bookId: Long
    ): Flow<BookRequestBody> = flow {
        emit(
            MindWayAPIHandler<BookRequestBody>()
                .httpRequest { bookAPI.bookGetById(bookId = bookId) }
                .sendRequest()
        )
    }.flowOn(Dispatchers.IO)

    override suspend fun bookModify(
        body: BookRequestBody,
        bookId: Long
    ): Flow<Unit> = flow {
        emit(
            MindWayAPIHandler<Unit>()
                .httpRequest { bookAPI.bookModify(body = body, bookId = bookId) }
                .sendRequest()
        )
    }.flowOn(Dispatchers.IO)

    override suspend fun bookDeleteById(bookId: Long): Flow<Unit> = flow {
        emit(
            MindWayAPIHandler<Unit>()
                .httpRequest { bookAPI.bookDeleteById(bookId = bookId) }
                .sendRequest()
        )
    }.flowOn(Dispatchers.IO)
}