package com.chobo.data.repository

import com.chobo.data.remote.datasource.notice.RemoteNoticeDataSource
import com.chobo.data.remote.dto.notice.toModel
import com.chobo.domain.model.notice.NoticeAllModel
import com.chobo.domain.repository.NoticeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class NoticeRepositoryImpl @Inject constructor(
    private val noticeDataSource: RemoteNoticeDataSource
) : NoticeRepository {
    override fun noticeGet(): Flow<NoticeAllModel> =
        noticeDataSource.bookGet().map { it.toModel() }
}