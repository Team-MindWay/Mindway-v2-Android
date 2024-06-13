package com.chobo.domain.repository

import com.chobo.domain.model.my.MyBookListModel
import com.chobo.domain.model.my.MyDataModel
import kotlinx.coroutines.flow.Flow

interface MyRepository {
    suspend fun myInformationGet(): Flow<MyDataModel>

    suspend fun myBookListGet(): Flow<List<MyBookListModel>>
}