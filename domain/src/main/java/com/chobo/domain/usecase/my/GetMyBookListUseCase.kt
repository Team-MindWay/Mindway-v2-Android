
package com.chobo.domain.usecase.my

import com.chobo.domain.model.my.MyBookListModel
import com.chobo.domain.repository.MyRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetMyBookListUseCase @Inject constructor(
    private val myRepository: MyRepository
) {
    suspend operator fun invoke(): Flow<List<MyBookListModel>> =
        myRepository.myBookListGet()
}