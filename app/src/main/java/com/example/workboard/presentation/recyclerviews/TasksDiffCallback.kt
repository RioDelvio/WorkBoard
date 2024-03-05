package com.example.workboard.presentation.recyclerviews

import androidx.recyclerview.widget.DiffUtil
import com.example.workboard.domain.entities.Task

object TasksDiffCallback: DiffUtil.ItemCallback<Task>() {
    override fun areItemsTheSame(oldItem: Task, newItem: Task): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Task, newItem: Task): Boolean {
        return oldItem == newItem
    }
}