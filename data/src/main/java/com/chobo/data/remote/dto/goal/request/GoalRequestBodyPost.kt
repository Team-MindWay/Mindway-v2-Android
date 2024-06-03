package com.chobo.data.remote.dto.goal.request

import com.chobo.domain.model.goal.request.PostGoalRequestModel

data class GoalRequestBodyPost(
    val goal_count: Int
)

fun PostGoalRequestModel.toDto() = GoalRequestBodyPost(
    goal_count = goal_count
)