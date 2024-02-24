package com.example.workboard.domain

import androidx.lifecycle.LiveData
import com.example.workboard.domain.entities.Note
import com.example.workboard.domain.entities.Task

interface WorkBoardRepository {

    fun addNote(note: Note)
    fun addTask(task: Task)
    fun deleteNote(id: Int)
    fun deleteTask(id: Int)
    fun getNote(id: Int): Note
    fun getTask(id: Int): Task
    fun getNoteList(): LiveData<List<Note>>
    fun getTaskList(): LiveData<List<Task>>
    fun editNote(note: Note)
    fun editTask(task: Task)
}