package com.example.workboard.domain.entities

import android.os.Parcel
import android.os.Parcelable
import androidx.room.PrimaryKey

data class Task(
    var id: Int = UNDEFINED_ID,
    val title: String?,
    val isDone: Boolean = false
) {
    companion object{
        const val UNDEFINED_ID = 0
    }
}