package com.example.workboard.presentation

import android.app.Application
import com.example.workboard.di.DaggerApplicationComponent

class WorkBoardApp: Application() {

    val component by lazy {
        DaggerApplicationComponent.factory().create(this)
    }
    override fun onCreate() {
        super.onCreate()
        component.inject(this)
    }
}