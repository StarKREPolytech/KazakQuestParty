package com.example.anton.birthdayparty.model.task.tasks

import com.example.anton.birthdayparty.R
import com.example.anton.birthdayparty.model.task.Task
import com.example.anton.birthdayparty.model.task.TaskStyle

private const val DESCRIPTION = R.drawable.task_3

private const val KEYCODE = "3421"

private val STYLE = TaskStyle(
    R.color.grey_dark,
    R.color.green_light,
    R.color.green_smooth,
    R.color.white
)

val TASK_3 = Task(DESCRIPTION, KEYCODE, STYLE)