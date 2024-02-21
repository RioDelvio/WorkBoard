package com.example.workboard.di

import android.app.Application
import com.example.workboard.presentation.WorkBoardApp
import dagger.BindsInstance
import dagger.Component

@ApplicationScope
@Component
interface ApplicationComponent {

    fun inject(workBoardApp: WorkBoardApp)

    @Component.Factory
    interface Factory {

        fun create(
            @BindsInstance application: Application
        ): ApplicationComponent
    }
}