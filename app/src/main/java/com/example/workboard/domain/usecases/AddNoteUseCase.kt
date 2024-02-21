package com.example.workboard.domain.usecases

import com.example.workboard.domain.WorkBoardRepository
import com.example.workboard.domain.entities.Note
import javax.inject.Inject

class AddNoteUseCase @Inject constructor(private val workBoardRepository: WorkBoardRepository) {

    operator fun invoke(note: Note) = workBoardRepository.addNote(note)
}