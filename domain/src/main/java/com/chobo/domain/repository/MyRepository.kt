package com.chobo.domain.repository

import com.chobo.domain.model.my.MyBookListModel
import com.chobo.domain.model.my.MyDataModel
import kotlinx.coroutines.flow.Flow

interface MyRepository {
     fun myInformationGet(): Flow<MyDataModel>

     fun myBookListGet(): Flow<List<MyBookListModel>>
}