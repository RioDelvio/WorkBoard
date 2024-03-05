package com.example.workboard.data.mapper

import com.example.workboard.data.dbmodels.NoteDbModel
import com.example.workboard.data.dbmodels.TaskDbModel
import com.example.workboard.domain.entities.Note
import com.example.workboard.domain.entities.Task
import javax.inject.Inject

class Mapper @Inject constructor() {

    fun mapTaskDbModelToEntity(dbModel: TaskDbModel): Task {
        return Task(id = dbModel.id, title = dbModel.title, isDone = dbModel.isDone)
    }
    fun mapNoteDbModelToEntity(dbModel: NoteDbModel): Note {
        return Note(id = dbModel.id, title = dbModel.title)
    }
    fun mapTaskEntityToDbModel(entity: Task): TaskDbModel {
        return TaskDbModel(id = entity.id, title = entity.title ?: "", isDone = entity.isDone)
    }
    fun mapNoteEntityToDbModel(entity: Note): NoteDbModel {
        return NoteDbModel(id = entity.id, title = entity.title)
    }

    fun mapTaskListDbModelToListEntity(list: List<TaskDbModel>) = list.map {
        mapTaskDbModelToEntity(it)
    }
    fun mapNoteListDbModelToListEntity(list: List<NoteDbModel>) = list.map {
        mapNoteDbModelToEntity(it)
    }


}