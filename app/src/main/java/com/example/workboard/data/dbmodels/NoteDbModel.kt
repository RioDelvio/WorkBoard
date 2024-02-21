package com.example.workboard.data.dbmodels

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "note_list")
data class NoteDbModel(
    @PrimaryKey
    val id: Int,
    val title: String
)