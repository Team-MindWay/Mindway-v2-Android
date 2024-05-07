package com.chobo.domain.usecase.event

import com.chobo.domain.repository.EventRepository
import javax.inject.Inject

class GetEventListUseCase @Inject constructor(
    private val eventRepository: EventRepository
) {
    suspend operator fun invoke(status: String) = runCatching {
        eventRepository.getEventList(status = status)
    }
}