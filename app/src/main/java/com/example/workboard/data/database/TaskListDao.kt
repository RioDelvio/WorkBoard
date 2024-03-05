package com.example.workboard.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.workboard.data.dbmodels.TaskDbModel
import com.example.workboard.domain.entities.Task

@Dao
interface TaskListDao {

    @Query("SELECT * FROM task_list")
    fun getTaskList(): LiveData<List<TaskDbModel>>
    @Query("SELECT * FROM task_list WHERE id=:id LIMIT 1")
    suspend fun getTask(id: Int): TaskDbModel
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addTask(task: TaskDbModel)
    @Query("DELETE FROM task_list WHERE id=:taskId")
    suspend fun deleteTask(taskId: Int)
}