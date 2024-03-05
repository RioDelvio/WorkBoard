package com.example.workboard.data.dbmodels

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "task_list")
data class TaskDbModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val title: String,
    val isDone: Boolean
)