package com.chobo.data.remote.api

import com.chobo.data.remote.dto.book.request.BookRequestBody
import com.chobo.data.remote.dto.book.response.BookListResponse
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.Path

interface BookAPI {
    @POST("/api/v2/book")
    suspend fun bookPost(
        @Body body: BookRequestBody,
    )

    @GET("/api/v2/book")
    suspend fun bookListGet(): List<BookListResponse>

    @GET("/api/v2/book/{book_id}")
    suspend fun bookGet(
        @Path("book_id") bookId: Long
    ): BookListResponse

    @PATCH("/api/v2/book/{book_id}")
    suspend fun bookPatch(
        @Body body: BookRequestBody,
        @Path("book_id") bookId: Long
    )

    @DELETE("/api/v2/book/{book_id}")
    suspend fun bookDelete(
        @Path("book_id") bookId: Long
    )
}