package com.example.workboard.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.workboard.domain.entities.Task
import com.example.workboard.domain.usecases.AddTaskUseCase
import com.example.workboard.domain.usecases.EditTaskUseCase
import com.example.workboard.domain.usecases.GetTaskUseCase
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import javax.inject.Inject

class CreateTaskViewModel @Inject constructor(
    private val getTaskUseCase: GetTaskUseCase,
    private val addTaskUseCase: AddTaskUseCase,
    private val editTaskUseCase: EditTaskUseCase
) : ViewModel() {


    private val _task = MutableLiveData<Task>()
    val task: LiveData<Task>
        get() = _task


    fun getTask(taskId: Int) {
        viewModelScope.launch {
            val task = getTaskUseCase(taskId)
            _task.value = task
        }
    }
    fun addTask(task: Task) {
        viewModelScope.launch {
            addTaskUseCase(task)
        }
    }

    fun editTask(task: Task) {
        viewModelScope.launch {
            editTaskUseCase(task)
        }
    }
}