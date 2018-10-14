package com.example.anton.birthdayparty.managment

import com.example.anton.birthdayparty.model.task.Task
import com.example.anton.birthdayparty.model.task.tasks.*

class QuestManager {

    /**
     * Task number.
     */

    private var level = 0

    /**
     * Task list.
     */

    private val questList = mutableListOf<Task>()

    /**
     * Get current level task.
     */

    fun getCurrentTask() = this.questList[this.level]

    /**
     * Finish current level.
     * Returns true if level is finished else false
     */

    fun tryToFinishTask(keyCode: String): GameEventType {
        val task = this.questList[this.level]
        return if (task.keyCode == keyCode) {
            if (this.level == this.questList.size - 1) {
                GameEventType.GAME_IS_FINISHED
            } else {
                this.level++
                GameEventType.TASK_IS_FINISHED
            }
        } else {
            GameEventType.TASK_IS_NOT_FINISHED
        }
    }

    /**
     * Fill quest list.
     */

    init {
        this.questList.add(TASK_1)
        this.questList.add(TASK_2)
        this.questList.add(TASK_3)
        this.questList.add(TASK_4)
        this.questList.add(TASK_5)
        this.questList.add(TASK_6)
        this.questList.add(TASK_7)
        this.questList.add(TASK_8)
        this.questList.add(TASK_9)
    }

    enum class GameEventType {
        TASK_IS_NOT_FINISHED,
        TASK_IS_FINISHED,
        GAME_IS_FINISHED
    }
}