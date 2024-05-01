package com.chobo.data.remote.datasource.notice

import com.chobo.data.remote.api.NoticeAPI
import com.chobo.data.remote.dto.notice.NoticeAll
import com.chobo.data.util.MindWayAPIHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class RemoteNoticeDataSourceImpl @Inject constructor(
    private val noticeAPI: NoticeAPI
) : RemoteNoticeDataSource {
    override suspend fun bookGet(): Flow<NoticeAll> = flow {
        emit(
            MindWayAPIHandler<NoticeAll>()
                .httpRequest { noticeAPI.noticeGet() }
                .sendRequest()
        )
    }.flowOn(Dispatchers.IO)
}