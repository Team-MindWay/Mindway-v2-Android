package com.chobo.domain.repository

import com.chobo.domain.model.notice.NoticeAllModel
import kotlinx.coroutines.flow.Flow

interface NoticeRepository {
    suspend fun noticeGet(): Flow<NoticeAllModel>

}