package com.example.workboard.domain.usecases

import com.example.workboard.domain.WorkBoardRepository
import javax.inject.Inject

class GetNoteListUseCase @Inject constructor(private val repository: WorkBoardRepository) {

    operator fun invoke() = repository.getNoteList()
}