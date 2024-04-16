package com.chobo.data.remote.api

import com.chobo.data.remote.dto.response.my.MyResponse
import retrofit2.http.GET
import retrofit2.http.Header

interface MyAPI {
    @GET("/api/v2/my")
    fun myInformationGet(
        @Header("Authorization") authorization: String
    ): MyResponse

    @GET("/api/v2/my")
    fun myBookListGet(
        @Header("Authorization") authorization: String
    ): MyResponse
}