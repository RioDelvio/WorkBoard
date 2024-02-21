package com.example.workboard.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.example.workboard.data.database.NoteListDao
import com.example.workboard.data.database.TaskListDao
import com.example.workboard.data.mapper.Mapper
import com.example.workboard.domain.WorkBoardRepository
import com.example.workboard.domain.entities.Note
import com.example.workboard.domain.entities.Task
import javax.inject.Inject


class WorkBoardRepositoryImpl @Inject constructor(
    private val taskListDao: TaskListDao,
    private val noteListDao: NoteListDao,
    private val mapper: Mapper
): WorkBoardRepository{
    override fun addNote(note: Note) {
        noteListDao.addNote(mapper.mapNoteEntityToDbModel(note))
    }

    override fun addTask(task: Task) {
        taskListDao.addTask(mapper.mapTaskEntityToDbModel(task))
    }

    override fun deleteNote(id: Int) {
        noteListDao.deleteNote(id)
    }

    override fun deleteTask(id: Int) {
        taskListDao.deleteTask(id)
    }

    override fun getNote(id: Int): Note {
        val dbModel = noteListDao.getNote(id)
        return mapper.mapNoteDbModelToEntity(dbModel)
    }

    override fun getTask(id: Int): Task {
        val dbModel = taskListDao.getTask(id)
        return mapper.mapTaskDbModelToEntity(dbModel)
    }

    override fun getNoteList(): LiveData<List<Note>> =
        noteListDao.getNoteList().map {
            mapper.mapNoteListDbModelToListEntity(it)
        }

    override fun getTaskList(): LiveData<List<Task>> =
        taskListDao.getTaskList().map {
            mapper.mapTaskListDbModelToListEntity(it)
        }

    override fun editNote(note: Note) {
        noteListDao.addNote(mapper.mapNoteEntityToDbModel(note))
    }

    override fun editTask(task: Task) {
        taskListDao.addTask(mapper.mapTaskEntityToDbModel(task))
    }

}