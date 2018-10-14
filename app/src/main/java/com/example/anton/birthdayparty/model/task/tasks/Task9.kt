package com.example.anton.birthdayparty.model.task.tasks

import com.example.anton.birthdayparty.R
import com.example.anton.birthdayparty.model.task.Task
import com.example.anton.birthdayparty.model.task.TaskStyle


private const val DESCRIPTION = R.drawable.task_9

private const val KEYCODE = "1321"

private val STYLE = TaskStyle(
    R.color.holo_green,
    R.color.holo_blue,
    R.color.holo_green_smooth,
    R.color.white
)

val TASK_9 = Task(DESCRIPTION, KEYCODE, STYLE)