package com.example.anton.birthdayparty

import android.annotation.SuppressLint
import android.content.res.ColorStateList
import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.anton.birthdayparty.core.App
import com.example.anton.birthdayparty.managment.QuestManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val questManager
        get() = (this.application as App).questManager

    private lateinit var mediaPlayer: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.setContentView(R.layout.activity_main)
        this.initFab()
        this.initMediaPlayer()
        this.drawNextTask()
    }

    @SuppressLint("NewApi")
    override fun onStart() {
        super.onStart()
    }

    override fun onPause() {
        super.onPause()
        this.resetMediaPlayer()
    }

    private fun initMediaPlayer() {
        val player = MediaPlayer.create(this.applicationContext, R.raw.victory_theme)
        player.setOnCompletionListener { this.resetMediaPlayer() }
        this.mediaPlayer = player
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
        this.coordinator.background = this.getDrawable(style.coordinatorBgColorId)
        this.description.background = getDrawable(newTask.descriptionId)
        this.key_code_edit_text.setBackgroundResource(style.keyCodeBgColorId)
        this.key_code_edit_text.setTextColor(this.getColor(style.keyCodeTextColorId))
        this.bottom_app_bar.backgroundTintList = ColorStateList.valueOf(this.getColor(style.bottomBarColorBgId))
//        this.fab.backgroundTintList = ColorStateList.valueOf(this.getColor(style.fabColorBgId))
        //Reset edit text:
        this.key_code_edit_text.text.clear()
    }

    private fun drawVictory() {
        this.mediaPlayer.start()
        this.coordinator.visibility = View.GONE
        this.key_code_edit_text.visibility = View.GONE
    }

    private fun resetMediaPlayer() {
        this.mediaPlayer.stop()
        this.mediaPlayer.release()
    }
}