package com.example.anton.birthdayparty

import android.annotation.SuppressLint
import android.content.res.ColorStateList
import android.os.Bundle
import android.view.View
import android.widget.MediaController
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.anton.birthdayparty.core.App
import com.example.anton.birthdayparty.managment.QuestManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val questManager
        get() = (this.application as App).questManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.setContentView(R.layout.activity_main)
        this.initFab()
        this.drawNextTask()
//        this.drawVictory()
    }

    @SuppressLint("NewApi")
    override fun onStart() {
        super.onStart()
        this.initVideoPlayer()
    }

    private fun initVideoPlayer() {
        val mediaController = MediaController(this)
        mediaController.setAnchorView(this.video)
        this.video.setMediaController(mediaController)
        this.video.setVideoPath("android.resource://" + this.packageName + "/" + R.raw.movie)
        this.video.setOnCompletionListener {
            this.finish()
            System.exit(0)
        }
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

    private fun drawNextTask() {
        val newTask = this.questManager.getCurrentTask()
        val style = newTask.style
        //Set style:
        this.coordinator.background = this.getDrawable(style.coordinatorBgColorId)
        this.description.background = getDrawable(newTask.descriptionId)
        this.key_code_edit_text.setBackgroundResource(style.keyCodeBgColorId)
        this.key_code_edit_text.setTextColor(this.resources.getColor(style.keyCodeTextColorId))
        this.bottom_app_bar.backgroundTintList = ColorStateList.valueOf(
            this.resources.getColor(style.bottomBarColorBgId)
        )
        //Reset edit text:
        this.key_code_edit_text.text.clear()
    }

    private fun drawVictory() {
        this.coordinator.visibility = View.GONE
        this.description.visibility = View.GONE
        this.key_code_edit_text.visibility = View.GONE
        this.launchVideo()
    }

    private fun launchVideo() {
        this.video.visibility = View.VISIBLE
        this.video.start()
    }
}