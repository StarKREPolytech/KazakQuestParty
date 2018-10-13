package com.example.anton.birthdayparty.model.task.tasks

import com.example.anton.birthdayparty.R
import com.example.anton.birthdayparty.model.task.Task
import com.example.anton.birthdayparty.model.task.TaskStyle

private const val DESCRIPTION = "Выйди из в комнаты 127 и скажи 'Пока'!"

private const val KEYCODE = "4321"

private val STYLE = TaskStyle(
    R.color.purple_dark,
    R.color.green_dark,
    R.color.green_light,
    R.color.white,
    R.color.green_dark,
    R.color.black,
    R.color.black
)

val TASK_2 = Task(DESCRIPTION, KEYCODE, STYLE)