package com.chobo.domain.usecase.event

import com.chobo.domain.repository.EventRepository
import javax.inject.Inject

class DeleteEventUseCase @Inject constructor(
    private val eventRepository: EventRepository
) {
    suspend operator fun invoke(eventId: Long) = runCatching {
        eventRepository.deleteEvent(eventId = eventId)
    }
}