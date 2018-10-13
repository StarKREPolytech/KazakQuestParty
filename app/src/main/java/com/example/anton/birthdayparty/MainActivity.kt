package com.example.anton.birthdayparty

import android.annotation.SuppressLint
import android.content.res.ColorStateList
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.anton.birthdayparty.managment.QuestManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val questManager = QuestManager()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.setContentView(R.layout.activity_main)
        this.initFab()
        this.drawNextTask()
    }

    private fun initFab() {
        this.fab.setOnClickListener {
            val keyCode: String = this.key_code_edit_text.text.toString()
            val taskResult = this.questManager.tryToFinishTask(keyCode)
            when (taskResult) {
                QuestManager.GameEventType.TASK_IS_NOT_FINISHED -> this.drawError()
                QuestManager.GameEventType.TASK_IS_FINISHED -> this.drawNextTask()
                QuestManager.GameEventType.GAME_IS_FINISHED -> this.drawVictory()
            }
        }
    }

    private fun drawError() {
        Toast.makeText(this.baseContext, "Неверный ключ", Toast.LENGTH_SHORT).show()
    }

    @SuppressLint("NewApi")
    private fun drawNextTask() {
        val newTask = this.questManager.getCurrentTask()
        val style = newTask.style
        //Set style:
        this.description.text = newTask.description
        this.coordinator.background = this.getDrawable(style.coordinatorBgColorId)
        this.description.setBackgroundResource(R.color.green_light)
        this.description.setTextColor(this.getColor(R.color.black))
        this.key_code_edit_text.setBackgroundResource(R.color.green_light)
        this.key_code_edit_text.setTextColor(this.getColor(R.color.black))
        this.bottom_app_bar.backgroundTintList = ColorStateList.valueOf(this.getColor(R.color.green_light))
        this.fab.backgroundTintList = ColorStateList.valueOf(this.getColor(R.color.green_light))
        //Reset edit text:
        this.key_code_edit_text.text.clear()
    }

    private fun drawVictory() {
        Toast.makeText(this.baseContext, "Вы выиграли!", Toast.LENGTH_SHORT).show()
    }
}