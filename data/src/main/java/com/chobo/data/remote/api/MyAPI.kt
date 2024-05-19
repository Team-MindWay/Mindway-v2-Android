package com.chobo.data.remote.api

import com.chobo.data.remote.dto.my_response.MyResponse
import retrofit2.http.GET

interface MyAPI {
    @GET("/api/v2/my")
    suspend fun myInformationGet(): MyResponse

    @GET("/api/v2/my/book")
    suspend fun myBookListGet(): MyResponse
}