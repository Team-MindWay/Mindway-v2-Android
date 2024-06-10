package com.chobo.data.remote.api

import com.chobo.data.remote.dto.my_response.MyBookListResponse
import com.chobo.data.remote.dto.my_response.MyDataResponse
import retrofit2.http.GET

interface MyAPI {
    @GET("/api/v2/my")
    suspend fun myInformationGet(): MyDataResponse

    @GET("/api/v2/my/book")
    suspend fun myBookListGet(): List<MyBookListResponse>
}