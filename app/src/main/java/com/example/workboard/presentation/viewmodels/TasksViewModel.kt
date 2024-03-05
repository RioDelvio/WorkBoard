package com.example.workboard.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.workboard.domain.entities.Task
import com.example.workboard.domain.usecases.AddTaskUseCase
import com.example.workboard.domain.usecases.DeleteTaskUseCase
import com.example.workboard.domain.usecases.GetTaskListUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class TasksViewModel @Inject constructor(
    private val getTaskListUseCase: GetTaskListUseCase,
    private val deleteTaskUseCase: DeleteTaskUseCase,
    private val addTaskUseCase: AddTaskUseCase
) : ViewModel() {

    val getTaskList = getTaskListUseCase()

    fun deleteTask(taskId: Int) {
        viewModelScope.launch {
            deleteTaskUseCase(taskId)
        }
    }
    fun changeCompleteState(task: Task){
         viewModelScope.launch{
            val newTask = Task(task.id, task.title, !task.isDone)
            addTaskUseCase(newTask)
        }
    }

}