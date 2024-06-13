package com.chobo.data.remote.api

import com.chobo.data.remote.dto.book.request.BookRequestBody
import com.chobo.data.remote.dto.book.response.BookListResponse
import retrofit2.http.*

interface BookAPI {
    @POST("/api/v2/book")
    suspend fun bookUpload(
        @Body body: BookRequestBody,
    )

    @GET("/api/v2/book")
    suspend fun bookListGet(): List<BookListResponse>

    @GET("/api/v2/book/{book_id}")
    suspend fun bookGetById(
        @Path("book_id") bookId: Long
    ): BookRequestBody

    @PATCH("/api/v2/book/{book_id}")
    suspend fun bookModify(
        @Body body: BookRequestBody,
        @Path("book_id") bookId: Long
    )

    @DELETE("/api/v2/book/{book_id}")
    suspend fun bookDeleteById(
        @Path("book_id") bookId: Long
    )
}