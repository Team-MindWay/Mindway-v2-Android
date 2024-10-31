package com.chobo.domain.usecase.my

import com.chobo.domain.model.my.MyDataModel
import com.chobo.domain.repository.MyRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetMyInformationUseCase @Inject constructor(
    private val myRepository: MyRepository
) {
    operator fun invoke(): Flow<MyDataModel> =
        myRepository.myInformationGet()
}