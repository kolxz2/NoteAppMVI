package com.example.noteapp.presenter.screens.main

import com.example.noteapp.domain.model.NoteModel
import com.example.noteapp.presenter.screens.base.UiState
import javax.annotation.concurrent.Immutable

@Immutable
data class MainScreenState(
    val isLoading: Boolean,
    val data:List<NoteModel>,
    val error: String? = null
): UiState{
    companion object{
        fun initial() = MainScreenState(isLoading = true, data = emptyList(), error = null)
    }
}
