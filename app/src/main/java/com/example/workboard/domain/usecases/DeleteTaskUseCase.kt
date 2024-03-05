package com.example.workboard.domain.usecases

import com.example.workboard.domain.WorkBoardRepository
import javax.inject.Inject

class DeleteTaskUseCase @Inject constructor(private val repository: WorkBoardRepository) {

    suspend operator fun invoke(id: Int) = repository.deleteTask(id)
}