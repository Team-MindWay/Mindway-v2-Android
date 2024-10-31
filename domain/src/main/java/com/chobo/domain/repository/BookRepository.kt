package com.chobo.domain.repository

import com.chobo.domain.model.book.request.BookRequestBodyModel
import com.chobo.domain.model.book.response.BookListResponseModel
import kotlinx.coroutines.flow.Flow

interface BookRepository {
     fun bookUpload(body: BookRequestBodyModel): Flow<Unit>
     fun bookListGet(): Flow<List<BookListResponseModel>>
     fun bookGetById(bookId: Long): Flow<BookRequestBodyModel>
     fun bookModify(bookId: Long, body: BookRequestBodyModel): Flow<Unit>
     fun bookDeleteById(bookId: Long): Flow<Unit>
}