package com.chobo.domain.model.goal
data class GetGoalModel(
    val mon: Int,
    val tue: Int,
    val wed: Int,
    val thu: Int,
    val fri: Int,
    val sat: Int,
    val sun: Int,
    val now_count: Int,
    val goal_value: Int
)
