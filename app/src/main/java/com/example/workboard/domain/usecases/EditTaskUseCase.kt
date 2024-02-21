package com.example.workboard.domain.usecases

import com.example.workboard.domain.WorkBoardRepository
import com.example.workboard.domain.entities.Task
import javax.inject.Inject

class EditTaskUseCase @Inject constructor(private val repository: WorkBoardRepository){

    operator fun invoke(task: Task) = repository.editTask(task)
}