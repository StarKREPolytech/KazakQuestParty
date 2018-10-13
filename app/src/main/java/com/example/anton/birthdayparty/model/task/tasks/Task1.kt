package com.example.anton.birthdayparty.model.task.tasks

import com.example.anton.birthdayparty.R
import com.example.anton.birthdayparty.model.task.Task
import com.example.anton.birthdayparty.model.task.TaskStyle

private const val DESCRIPTION = "Зайди в комнату 127 и скажи 'Привет'!"

private const val KEYCODE = "1234"

private val STYLE = TaskStyle(
    R.color.black,
    R.color.grey_light,
    R.color.grey_dark,
    R.color.purple_dark,
    R.color.grey_light,
    R.color.black,
    R.color.black
)

val TASK_1 = Task(DESCRIPTION, KEYCODE, STYLE)