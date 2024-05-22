package com.chobo.presentation.viewModel.event

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chobo.domain.emumtype.EventRequestListStatusType
import com.chobo.domain.usecase.event.GetDetailEventUseCase
import com.chobo.domain.usecase.event.GetEventDateListUseCase
import com.chobo.domain.usecase.event.GetEventListUseCase
import com.chobo.presentation.view.event.component.EventsData
import com.chobo.presentation.viewModel.event.uistate.GetDetailEventUiState
import com.chobo.presentation.viewModel.event.uistate.GetEventDateListUiState
import com.chobo.presentation.viewModel.event.uistate.GetEventListUiState
import com.chobo.presentation.viewModel.util.result.Result
import com.chobo.presentation.viewModel.util.result.asResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EventViewModel @Inject constructor(
    private val getEventListUseCase: GetEventListUseCase,
    private val getEventDetailUseCase: GetDetailEventUseCase,
    private val getEventDateListUseCase: GetEventDateListUseCase,
) : ViewModel() {
    private val _currentEventsDataList = MutableStateFlow<List<EventsData>>(listOf())
    val currentEventsDataList: StateFlow<List<EventsData>> = _currentEventsDataList.asStateFlow()

    private val _pastEventsDataList = MutableStateFlow<List<EventsData>>(listOf())
    val pastEventsDataList: StateFlow<List<EventsData>> = _pastEventsDataList.asStateFlow()

    private val _getEventListUiState = MutableStateFlow<GetEventListUiState>(GetEventListUiState.Loading)
    val getEventListUiState = _getEventListUiState.asStateFlow()

    private val _getDetailEventUiState = MutableStateFlow<GetDetailEventUiState>(GetDetailEventUiState.Loading)
    val getDetailEventUiState = _getDetailEventUiState.asStateFlow()

    private val _getEventDateListUiState = MutableStateFlow<GetEventDateListUiState>(GetEventDateListUiState.Loading)
    val getEventDateListUiState = _getEventDateListUiState.asStateFlow()

    fun getEventList(status: EventRequestListStatusType) = viewModelScope.launch {
        val targetStateFlow = when (status) {
            EventRequestListStatusType.PENDING -> _getEventListUiState
            EventRequestListStatusType.PAST -> _getEventListUiState
            EventRequestListStatusType.NOW -> _getEventListUiState
        }
        getEventListUseCase(status = status.name)
            .asResult()
            .collectLatest { result ->
                when(result) {
                    is Result.Loading -> targetStateFlow.value = GetEventListUiState.Loading
                    is Result.Success -> if (result.data.isEmpty()) {
                        targetStateFlow.value = GetEventListUiState.Empty
                    } else {
                        targetStateFlow.value = GetEventListUiState.Success(result.data)
                    }
                    is Result.Fail -> targetStateFlow.value = GetEventListUiState.Fail(result.exception)
                }
            }
    }

    fun getDetailEvent(eventId: Long) = viewModelScope.launch {
        getEventDetailUseCase(eventId = eventId)
            .asResult()
            .collectLatest { result ->
                when(result) {
                    is Result.Loading -> _getDetailEventUiState.value = GetDetailEventUiState.Loading
                    is Result.Success -> _getDetailEventUiState.value = GetDetailEventUiState.Success(result.data)
                    is Result.Fail -> _getDetailEventUiState.value = GetDetailEventUiState.Fail(result.exception)
                }
            }
    }

    fun getEventDataList(date: String) = viewModelScope.launch {
        getEventDateListUseCase(date = date)
            .asResult()
            .collectLatest { result ->
                when(result) {
                    is Result.Loading -> _getEventDateListUiState.value = GetEventDateListUiState.Loading
                    is Result.Success -> {
                        if (result.data.isEmpty()) {
                            _getEventDateListUiState.value = GetEventDateListUiState.Empty
                        } else {
                            _getEventDateListUiState.value =
                                GetEventDateListUiState.Success(result.data)
                        }
                    }
                    is Result.Fail -> _getEventDateListUiState.value = GetEventDateListUiState.Fail(result.exception)
                }
            }
    }

    fun onCurrentEventClick(index: Int) {
    }

    fun onPastEventClick(index: Int) {

    }

    init {
        _currentEventsDataList.value =
            MutableList(30) {
                EventsData(
                    title = "가을 독서 행사",
                    content = "독서의 계절, 가을을 맞아 도서관에서 특별한 이벤트를준비했습니다. 랜덤으로 초성 책 제목이 적혀있는 쪽지를 뽑고, 그에 맞는 책을 찾아오면 푸짐한 선물뽑기를 할 수 있습니다. 점심시간마다 진행할 예정이니 많은 관심 바랍니다.",
                    date = "2023년 06월 20일"
                )
            }
        _pastEventsDataList.value =
            MutableList(30) {
                EventsData(
                    title = "가을 독서 행사",
                    content = "독서의 계절, 가을을 맞아 도서관에서 특별한 이벤트를준비했습니다. 랜덤으로 초성 책 제목이 적혀있는 쪽지를 뽑고, 그에 맞는 책을 찾아오면 푸짐한 선물뽑기를 할 수 있습니다. 점심시간마다 진행할 예정이니 많은 관심 바랍니다.",
                    date = "2023년 06월 20일"
                )
            }
    }
}