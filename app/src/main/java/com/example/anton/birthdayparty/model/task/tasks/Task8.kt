package com.example.anton.birthdayparty.model.task.tasks

import com.example.anton.birthdayparty.R
import com.example.anton.birthdayparty.model.task.Task
import com.example.anton.birthdayparty.model.task.TaskStyle


private const val DESCRIPTION = R.drawable.task_8

private const val KEYCODE = "0995"

private val STYLE = TaskStyle(
    R.color.light_white,
    R.color.blood_dark,
    R.color.blood_smooth,
    R.color.white
)

val TASK_8 = Task(DESCRIPTION, KEYCODE, STYLE)