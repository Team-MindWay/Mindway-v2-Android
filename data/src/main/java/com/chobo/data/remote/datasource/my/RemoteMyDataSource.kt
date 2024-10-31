package com.chobo.data.remote.datasource.my

import com.chobo.data.remote.dto.my_response.MyBookListResponse
import com.chobo.data.remote.dto.my_response.MyDataResponse
import com.chobo.domain.model.my.MyBookListModel
import kotlinx.coroutines.flow.Flow

interface RemoteMyDataSource {
     fun getMyInformation(): Flow<MyDataResponse>
     fun getMyBookList(): Flow<List<MyBookListResponse>>
}