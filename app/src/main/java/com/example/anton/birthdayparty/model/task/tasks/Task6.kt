package com.example.anton.birthdayparty.model.task.tasks

import com.example.anton.birthdayparty.R
import com.example.anton.birthdayparty.model.task.Task
import com.example.anton.birthdayparty.model.task.TaskStyle


private const val DESCRIPTION = R.drawable.task_6

private const val KEYCODE = "2333"

private val STYLE = TaskStyle(
    R.color.yellow,
    R.color.violet_smooth,
    R.color.yellow_smooth,
    R.color.white
)

val TASK_6 = Task(DESCRIPTION, KEYCODE, STYLE)