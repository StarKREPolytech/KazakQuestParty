package com.example.anton.birthdayparty.model.task.tasks

import com.example.anton.birthdayparty.R
import com.example.anton.birthdayparty.model.task.Task
import com.example.anton.birthdayparty.model.task.TaskStyle

private const val DESCRIPTION = R.drawable.task_4

private const val KEYCODE = "2375"

private val STYLE = TaskStyle(
    R.color.blue_light,
    R.color.blue_dark,
    R.color.blue_smooth,
    R.color.white
)

val TASK_4 = Task(DESCRIPTION, KEYCODE, STYLE)