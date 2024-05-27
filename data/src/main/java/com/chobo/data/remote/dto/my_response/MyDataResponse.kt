package com.chobo.data.remote.dto.my_response

import com.chobo.domain.model.my.MyDataModel

data class MyDataResponse(
    val name: String,
    val authority: String,
)

fun MyDataResponse.toModel() =
    MyDataModel(
        name = name,
        authority = authority
    )