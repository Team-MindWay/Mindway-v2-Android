package com.chobo.domain.usecase.notice

import com.chobo.domain.repository.NoticeRepository
import javax.inject.Inject

class NoticeGetUseCase @Inject constructor(
    private val noticeRepository: NoticeRepository
) {
    suspend operator fun invoke() = runCatching {
        noticeRepository.noticeGet()
    }
}