package com.chobo.data.remote.datasource.notice

import com.chobo.data.remote.dto.notice.NoticeAll
import kotlinx.coroutines.flow.Flow

interface RemoteNoticeDataSource {
    suspend fun bookGet(): Flow<NoticeAll>
}