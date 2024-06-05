package com.chobo.data.remote.dto.my_response

import com.chobo.domain.model.my.MyBookListModel

data class MyBookListResponse(
    val id: Long,
    val name: String,
    val author: String,
)

fun MyBookListResponse.toModel() = MyBookListModel(
    id = id,
    name = name,
    author = author
)