package com.chobo.data.remote.datasource.book

import com.chobo.data.remote.api.BookAPI
import com.chobo.data.remote.dto.book.request.BookRequestBody
import com.chobo.data.remote.dto.book.response.BookListResponse
import com.chobo.data.util.MindWayAPIHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class RemoteBookDataSourceImpl @Inject constructor(
    private val bookAPI: BookAPI
) : RemoteBookDataSource {
    override suspend fun bookPost(body: BookRequestBody): Flow<Unit> = flow {
        emit(
            MindWayAPIHandler<Unit>()
                .httpRequest { bookAPI.bookPost(body = body) }
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

    override suspend fun bookPatch(
        body: BookRequestBody,
        bookId: Long
    ): Flow<Unit> = flow {
        emit(
            MindWayAPIHandler<Unit>()
                .httpRequest { bookAPI.bookPatch(body = body, bookId = bookId) }
                .sendRequest()
        )
    }.flowOn(Dispatchers.IO)

    override suspend fun bookDelete(bookId: Long): Flow<Unit> = flow {
        emit(
            MindWayAPIHandler<Unit>()
                .httpRequest { bookAPI.bookDelete(bookId = bookId) }
                .sendRequest()
        )
    }.flowOn(Dispatchers.IO)
}