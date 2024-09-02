package com.chobo.data.remote.dto.goal.request

import com.chobo.domain.model.goal.request.PostGoalRequestModel
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GoalRequestBodyPost(
    @Json(name = "goal_count") val goal_count: Int
)

fun PostGoalRequestModel.toDto() = GoalRequestBodyPost(
    goal_count = goal_count
)