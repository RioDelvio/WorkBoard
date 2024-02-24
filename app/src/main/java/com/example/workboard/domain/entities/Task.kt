package com.example.workboard.domain.entities

import androidx.room.PrimaryKey

data class Task(
    @PrimaryKey
    val id: Int,
    val title: String,
    val isDone: Boolean = false
)