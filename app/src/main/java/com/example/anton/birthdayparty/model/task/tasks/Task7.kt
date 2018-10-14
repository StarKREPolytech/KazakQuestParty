package com.example.anton.birthdayparty.model.task.tasks

import com.example.anton.birthdayparty.R
import com.example.anton.birthdayparty.model.task.Task
import com.example.anton.birthdayparty.model.task.TaskStyle


private const val DESCRIPTION = R.drawable.task_4

private const val KEYCODE = "4321"

private val STYLE = TaskStyle(
    R.color.sea,
    R.color.sea_dark,
    R.color.sea_smooth,
    R.color.white
)

val TASK_7 = Task(DESCRIPTION, KEYCODE, STYLE)