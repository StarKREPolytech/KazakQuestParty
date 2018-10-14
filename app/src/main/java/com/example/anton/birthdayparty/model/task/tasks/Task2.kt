package com.example.anton.birthdayparty.model.task.tasks

import com.example.anton.birthdayparty.R
import com.example.anton.birthdayparty.model.task.Task
import com.example.anton.birthdayparty.model.task.TaskStyle

private const val DESCRIPTION = R.drawable.task_2

private const val KEYCODE = "7541"

private val STYLE = TaskStyle(
    R.color.grey_dark,
    R.color.grey_light,
    R.color.grey_smooth,
    R.color.white
)

val TASK_2 = Task(DESCRIPTION, KEYCODE, STYLE)