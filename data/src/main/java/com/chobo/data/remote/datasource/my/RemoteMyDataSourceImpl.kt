package com.chobo.data.remote.datasource.my

import com.chobo.data.remote.api.MyAPI
import com.chobo.data.remote.dto.my_response.MyBookListResponse
import com.chobo.data.remote.dto.my_response.MyDataResponse
import com.chobo.data.util.MindWayAPIHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class RemoteMyDataSourceImpl @Inject constructor(
    private val myAPI: MyAPI
) : RemoteMyDataSource {
    override suspend fun getMyInformation(): Flow<MyDataResponse> = flow {
        emit(
            MindWayAPIHandler<MyDataResponse>()
                .httpRequest {
                    myAPI.myInformationGet()
                }
                .sendRequest()
        )
    }.flowOn(Dispatchers.IO)

    override suspend fun getMyBookList(): Flow<MyBookListResponse> = flow {
        emit(
            MindWayAPIHandler<MyBookListResponse>()
                .httpRequest {
                    myAPI.myBookListGet()
                }
                .sendRequest()
        )
    }.flowOn(Dispatchers.IO)
}