package com.chobo.domain.usecase.event

import com.chobo.domain.model.event.response.GetEventDateListResponseModel
import com.chobo.domain.repository.EventRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetEventDateListUseCase @Inject constructor(
    private val eventRepository: EventRepository
) {
    suspend operator fun invoke(date: String): Flow<List<GetEventDateListResponseModel>> =
        eventRepository.getEventDateList(date = date)
}