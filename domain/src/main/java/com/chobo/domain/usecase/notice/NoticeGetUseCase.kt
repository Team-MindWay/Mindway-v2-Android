package com.chobo.domain.usecase.notice

import com.chobo.domain.model.notice.NoticeAllModel
import com.chobo.domain.repository.NoticeRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class NoticeGetUseCase @Inject constructor(
    private val noticeRepository: NoticeRepository
) {
    suspend operator fun invoke(): Flow<NoticeAllModel> =
        noticeRepository.noticeGet()
}