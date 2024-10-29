package com.chobo.data.remote.datasource.my

import com.chobo.data.remote.api.MyAPI
import com.chobo.data.remote.dto.my_response.MyBookListResponse
import com.chobo.data.remote.dto.my_response.MyDataResponse
import com.chobo.data.util.performApiRequest
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RemoteMyDataSourceImpl @Inject constructor(
    private val myService: MyAPI,
) : RemoteMyDataSource {
    override  fun getMyInformation(): Flow<MyDataResponse> =
        performApiRequest { myService.myInformationGet() }

    override  fun getMyBookList(): Flow<List<MyBookListResponse>> =
        performApiRequest { myService.myBookListGet() }
}