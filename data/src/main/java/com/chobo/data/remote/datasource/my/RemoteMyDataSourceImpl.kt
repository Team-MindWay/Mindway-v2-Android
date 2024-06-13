package com.chobo.data.remote.datasource.my

import com.chobo.data.remote.api.MyAPI
import com.chobo.data.remote.dto.my_response.MyBookListResponse
import com.chobo.data.remote.dto.my_response.MyDataResponse
import com.chobo.data.util.performApiRequest
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RemoteMyDataSourceImpl @Inject constructor(
    private val myService: MyAPI,
) : RemoteMyDataSource {
    override suspend fun getMyInformation(): Flow<MyDataResponse> = flow {
        performApiRequest { myService.myInformationGet() }
    }

    override suspend fun getMyBookList(): Flow<List<MyBookListResponse>> = flow {
        performApiRequest { myService.myBookListGet() }
    }
}