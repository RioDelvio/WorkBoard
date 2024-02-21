package com.example.workboard.domain.usecases

import com.example.workboard.domain.WorkBoardRepository
import com.example.workboard.domain.entities.Note
import javax.inject.Inject

class EditNoteUseCase @Inject constructor(private val repository: WorkBoardRepository) {

    operator fun invoke(note: Note) = repository.editNote(note)
}