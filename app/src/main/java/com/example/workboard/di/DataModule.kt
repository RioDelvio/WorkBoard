package com.example.workboard.di

import android.app.Application
import com.example.workboard.data.WorkBoardRepositoryImpl
import com.example.workboard.data.database.AppDatabase
import com.example.workboard.data.database.NoteListDao
import com.example.workboard.data.database.TaskListDao
import com.example.workboard.domain.WorkBoardRepository
import dagger.Binds
import dagger.Module
import dagger.Provides


@Module
interface DataModule {
    @ApplicationScope
    @Binds
    fun bindWorkBoardRepository(impl: WorkBoardRepositoryImpl): WorkBoardRepository

    companion object {
        @ApplicationScope
        @Provides
        fun providesTaskListDao(application: Application): TaskListDao {
            return AppDatabase.getInstance(application).taskListDao()
        }
        @ApplicationScope
        @Provides
        fun providesNoteListDao(application: Application): NoteListDao {
            return AppDatabase.getInstance(application).noteListDao()
        }
    }
}