package com.example.anton.birthdayparty.model.task.tasks

import com.example.anton.birthdayparty.R
import com.example.anton.birthdayparty.model.task.Task
import com.example.anton.birthdayparty.model.task.TaskStyle

private const val DESCRIPTION = R.drawable.task_1

private const val KEYCODE = "1209"

private val STYLE = TaskStyle(
    R.color.purple_light,
    R.color.purple_dark,
    R.color.purple_smooth,
    R.color.white
)

val TASK_1 = Task(DESCRIPTION, KEYCODE, STYLE)