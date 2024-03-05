package com.example.workboard.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.workboard.data.dbmodels.NoteDbModel
import com.example.workboard.data.dbmodels.TaskDbModel
import com.example.workboard.domain.entities.Task

@Dao
interface NoteListDao {

    @Query("SELECT * FROM note_list")
    fun getNoteList(): LiveData<List<NoteDbModel>>
    @Query("SELECT * FROM note_list WHERE id=:id LIMIT 1")
    suspend fun getNote(id: Int): NoteDbModel
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addNote(note: NoteDbModel)
    @Query("DELETE FROM note_list WHERE id=:taskId")
    suspend fun deleteNote(taskId: Int)
}