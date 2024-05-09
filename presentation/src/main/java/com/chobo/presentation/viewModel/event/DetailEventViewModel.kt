package com.chobo.presentation.viewModel

import androidx.lifecycle.ViewModel
import com.chobo.presentation.R
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class DetailEventViewModel @Inject constructor() : ViewModel() {
    private val _title = MutableStateFlow("")
    val title: StateFlow<String> = _title.asStateFlow()

    private val _content = MutableStateFlow("")
    val content: StateFlow<String> = _content.asStateFlow()

    private val _date = MutableStateFlow("")
    val date: StateFlow<String> = _date.asStateFlow()

    private val _imageResId = MutableStateFlow(0)
    val imageResId :StateFlow<Int> = _imageResId.asStateFlow()

    init {
        _title.value = "가을 독서 행사"
        _content.value = "독서의 계절, 가을을 맞아 도서관에서 특별한 이벤트를 준비했습니다. 랜덤으로 초성 책 제목이 적혀있는 쪽지를 뽑고, 그에 맞는 책을 찾아오면 푸짐한 선물뽑기를 할 수 있습니다. 점심시간마다 진행할 예정이니 많은 관심 바랍니다."
        _date.value = "2023년 06월 20일 ~ 2023년 07월 08일"
        _imageResId.value = R.drawable.mind_way_logo
    }
}
