package com.chobo.domain.usecase.event

import com.chobo.domain.repository.EventRepository
import javax.inject.Inject

class GetEventDateUseCase @Inject constructor(
    private val eventRepository: EventRepository
) {
    suspend operator fun invoke(date: String) = runCatching {
        eventRepository.getEventDate(date = date)
    }
}