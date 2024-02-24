package com.example.workboard.presentation.recyclerviews

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.workboard.databinding.ItemTaskBinding
import com.example.workboard.domain.entities.Task

class TasksListAdapter : ListAdapter<Task, TasksViewHolder>(TasksDiffCallback) {

    var onChangeCompletedStatus: ((Task) -> Unit)? = null

    var onLongTaskClickListener: ((Task) -> Unit)? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TasksViewHolder {
        val binding = ItemTaskBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return TasksViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TasksViewHolder, position: Int) {
        val task = getItem(position)
        with(holder.binding) {
            tvTasks.text = task.title
            checkBoxTask.isChecked = task.isDone
            checkBoxTask.setOnCheckedChangeListener { buttonView, isChecked ->
                onChangeCompletedStatus?.invoke(task)
            }
            this.taskItem.setOnLongClickListener {
                onLongTaskClickListener?.invoke(task)
                true
            }

        }

    }
}