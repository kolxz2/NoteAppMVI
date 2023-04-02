package com.example.noteapp.presenter.screens.main

import com.example.noteapp.domain.model.NoteModel
import com.example.noteapp.presenter.screens.base.UiEvent
import javax.annotation.concurrent.Immutable

@Immutable
sealed class MainScreenEvent: UiEvent{
    object LoadingData: MainScreenEvent()
    data class ShowData(val data: List<NoteModel>): MainScreenEvent()
    data class ShowError(val errorMessage: String): MainScreenEvent()
}
