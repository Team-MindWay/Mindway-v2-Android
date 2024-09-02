package com.chobo.data.remote.dto.my_response

import com.chobo.domain.model.my.MyDataModel
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MyDataResponse(
    @Json(name = "name") val name: String,
    @Json(name = "authority") val authority: String,
)

fun MyDataResponse.toModel() = MyDataModel(
    name = name,
    authority = authority
)