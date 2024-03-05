package com.example.workboard.domain

import androidx.lifecycle.LiveData
import com.example.workboard.domain.entities.Note
import com.example.workboard.domain.entities.Task

interface WorkBoardRepository {

    suspend fun addNote(note: Note)
    suspend fun addTask(task: Task)
    suspend fun deleteNote(id: Int)
    suspend fun deleteTask(id: Int)
    suspend fun getNote(id: Int): Note
    suspend fun getTask(id: Int): Task
    fun getNoteList(): LiveData<List<Note>>
    fun getTaskList(): LiveData<List<Task>>
    suspend fun editNote(note: Note)
    suspend fun editTask(task: Task)

}