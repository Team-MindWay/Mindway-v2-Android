package com.chobo.data.remote.dto.goal.response

import com.chobo.domain.model.goal.response.GetWeekendGoalModel

data class GoalWeekendResponse(
    val mon: Int,
    val tue: Int,
    val wed: Int,
    val thu: Int,
    val fri: Int,
    val sat: Int,
    val sun: Int,
    val now_count: Int,
    val goal_value: Int,
)

fun GoalWeekendResponse.toModel() = GetWeekendGoalModel(
    mon = mon,
    tue = tue,
    wed = wed,
    thu = thu,
    fri = fri,
    sat = sat,
    sun = sun,
    now_count = now_count,
    goal_value = goal_value
)