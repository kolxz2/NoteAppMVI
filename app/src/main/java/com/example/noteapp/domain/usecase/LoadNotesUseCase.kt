package com.example.noteapp.domain.usecase

import com.example.noteapp.data.DomainRepositoryImpl
import com.example.noteapp.domain.model.NoteModel
import javax.inject.Inject

class LoadNotesUseCase @Inject constructor(
    private val domainRepository: DomainRepositoryImpl
): BaseUseCase<List<NoteModel>>() {

    override suspend fun invoke(): List<NoteModel> = domainRepository.getAllNotes()
}