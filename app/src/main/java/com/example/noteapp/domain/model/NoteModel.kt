package com.example.noteapp.domain.model

import java.time.LocalDate
import java.util.Date

data class NoteModel(
    val id: Long,
    val title: String,
    val subtitle: String,
    val author: String,
    val date: LocalDate
)
