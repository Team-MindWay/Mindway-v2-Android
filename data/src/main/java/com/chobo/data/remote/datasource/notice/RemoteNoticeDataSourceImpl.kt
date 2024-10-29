package com.chobo.data.remote.datasource.notice

import com.chobo.data.remote.api.NoticeAPI
import com.chobo.data.remote.dto.notice.NoticeAll
import com.chobo.data.util.performApiRequest
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RemoteNoticeDataSourceImpl @Inject constructor(
    private val noticeService: NoticeAPI
) : RemoteNoticeDataSource {
    override fun bookGet(): Flow<NoticeAll> =
        performApiRequest { noticeService.noticeGet() }
}