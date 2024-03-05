package com.example.workboard.di

import android.app.Application
import com.example.workboard.presentation.MainActivity
import com.example.workboard.presentation.WorkBoardApp
import com.example.workboard.presentation.fragments.CreateTaskFragment
import com.example.workboard.presentation.fragments.NotesFragment
import com.example.workboard.presentation.fragments.TasksFragment
import dagger.BindsInstance
import dagger.Component

@ApplicationScope
@Component(
    modules = [DataModule::class, ViewModelModule::class]
)
interface ApplicationComponent {

    fun inject(workBoardApp: WorkBoardApp)
    fun inject(tasksFragment: TasksFragment)
    fun inject(createTaskFragment: CreateTaskFragment)
    fun inject(mainActivity: MainActivity)
    fun inject(notesFragment: NotesFragment)

    @Component.Factory
    interface Factory {

        fun create(
            @BindsInstance application: Application
        ): ApplicationComponent
    }
}