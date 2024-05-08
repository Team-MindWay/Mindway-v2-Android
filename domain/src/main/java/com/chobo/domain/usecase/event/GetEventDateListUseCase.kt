package com.chobo.domain.usecase.event

import com.chobo.domain.repository.EventRepository
import javax.inject.Inject

class GetEventDateListUseCase @Inject constructor(
    private val eventRepository: EventRepository
) {
    suspend operator fun invoke(date: String) = runCatching {
        eventRepository.getEventDateList(date = date)
    }
}