package com.chobo.data.repository

import com.chobo.data.remote.datasource.my.RemoteMyDataSource
import com.chobo.data.remote.dto.my_response.toModel
import com.chobo.domain.model.my.MyBookListModel
import com.chobo.domain.model.my.MyDataModel
import com.chobo.domain.repository.MyRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class MyRepositoryImpl @Inject constructor(
    private val myDataSource: RemoteMyDataSource,
) : MyRepository {
    override suspend fun myInformationGet(): Flow<MyDataModel> {
        return myDataSource.getMyInformation().map { it.toModel() }
    }

    override suspend fun myBookListGet(): Flow<List<MyBookListModel>> =
        myDataSource.getMyBookList().map { list -> list.map { it.toModel() } }
}