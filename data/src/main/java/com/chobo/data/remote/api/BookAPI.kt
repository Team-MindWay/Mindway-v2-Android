package com.chobo.data.remote.api

import com.chobo.data.remote.dto.book.request.BookRequestBody
import com.chobo.data.remote.dto.book.response.BookResponse
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST

interface BookAPI {
    @POST("/api/v2/book")
    fun bookPost(
        @Body body: BookRequestBody,
    )

    @GET("/api/v2/book")
    fun bookGet():BookResponse

    @PATCH("/api/v2/book/{book_id}")
    fun bookPatch(
        @Body body: BookRequestBody,
    )

    @DELETE("/api/v2/book/{book_id}")
    fun bookDelete()
}