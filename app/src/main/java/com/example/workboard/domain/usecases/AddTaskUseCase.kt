package com.example.workboard.domain.usecases

import com.example.workboard.domain.WorkBoardRepository
import com.example.workboard.domain.entities.Task
import javax.inject.Inject

class AddTaskUseCase @Inject constructor(private val repository: WorkBoardRepository){

    suspend operator fun invoke(task: Task) = repository.addTask(task)
}