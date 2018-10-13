package com.example.anton.birthdayparty.core

import android.app.Application
import com.example.anton.birthdayparty.managment.QuestManager

class App : Application() {

    val questManager = QuestManager()
}