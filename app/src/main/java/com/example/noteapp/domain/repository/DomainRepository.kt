package com.example.noteapp.domain.repository

import com.example.noteapp.domain.model.NoteModel


interface DomainRepository {
    suspend fun getAllNotes(): List<NoteModel>
}