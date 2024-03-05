package com.example.workboard.domain.usecases

import com.example.workboard.domain.WorkBoardRepository
import javax.inject.Inject

class GetTaskUseCase @Inject constructor(private val repository: WorkBoardRepository) {

    suspend operator fun invoke(id: Int) = repository.getTask(id)
}