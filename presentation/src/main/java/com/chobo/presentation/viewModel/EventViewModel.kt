package com.chobo.presentation.viewModel

import androidx.lifecycle.ViewModel
import com.chobo.presentation.view.event.component.EventsData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class EventViewModel @Inject constructor() : ViewModel() {
    private val _currentEventsDataList = MutableStateFlow<List<EventsData>>(listOf())
    val currentEventsDataList: StateFlow<List<EventsData>> = _currentEventsDataList.asStateFlow()

    private val _pastEventsDataList = MutableStateFlow<List<EventsData>>(listOf())
    val pastEventsDataList: StateFlow<List<EventsData>> = _pastEventsDataList.asStateFlow()

    fun onCurrentEventOnClick(index: Int) {

    }

    fun onPastEventOnClick(index: Int) {

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