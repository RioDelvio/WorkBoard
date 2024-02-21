package com.example.workboard.domain.usecases

import com.example.workboard.domain.WorkBoardRepository
import javax.inject.Inject

class GetNoteUseCase @Inject constructor(private val repository: WorkBoardRepository) {

    operator fun invoke(id: Int) = repository.getNote(id)
}