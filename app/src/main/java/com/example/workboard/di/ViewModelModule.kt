package com.example.workboard.di

import androidx.lifecycle.ViewModel
import com.example.workboard.presentation.viewmodels.NotesViewModel
import com.example.workboard.presentation.viewmodels.TasksViewModel
import com.example.workboard.presentation.viewmodels.WallViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @IntoMap
    @Binds
    @ViewModelKey(TasksViewModel::class)
    fun bindTaskViewModel(viewModel: TasksViewModel): ViewModel

    @IntoMap
    @Binds
    @ViewModelKey(NotesViewModel::class)
    fun bindNotesViewModel(viewModel: NotesViewModel): ViewModel

    @IntoMap
    @Binds
    @ViewModelKey(WallViewModel::class)
    fun bindWallViewModel(viewModel: WallViewModel): ViewModel
}