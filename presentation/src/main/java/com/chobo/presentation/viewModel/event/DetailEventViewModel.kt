package com.chobo.presentation.viewModel.event

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chobo.domain.model.event.response.GetDetailEventResponseModel
import com.chobo.presentation.view.util.decodeBase64ToBitmap
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailEventViewModel @Inject constructor() : ViewModel() {
    private val _detailData = MutableStateFlow(GetDetailEventResponseModel())
    val detailData: StateFlow<GetDetailEventResponseModel> = _detailData.asStateFlow()

    private suspend fun setDetailData(getDetailEventResponseModel: GetDetailEventResponseModel) {
        _detailData.value = getDetailEventResponseModel
    }

    init {
        viewModelScope.launch {
            setDetailData(
                GetDetailEventResponseModel(
                    title = "가을 독서 행사",
                    content = "독서의 계절, 가을을 맞아 도서관에서 특별한 이벤트를 준비했습니다. 랜덤으로 초성 책 제목이 적혀있는 쪽지를 뽑고, 그에 맞는 책을 찾아오면 푸짐한 선물뽑기를 할 수 있습니다. 점심시간마다 진행할 예정이니 많은 관심 바랍니다.",
                    image = decodeBase64ToBitmap("dsdsadas").toString(),
                    startedAt = "2023년 06월 20일",
                    endedAt = "2023년 07월 08일"
                )
            )
        }
    }
}
