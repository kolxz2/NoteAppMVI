package com.example.noteapp.presenter.screens.base

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow


/*
* Reducer получает текущее состояние модели и новые данные, которые необходимо
* обновить, а затем создает новое состояние модели, основанное на этих данных.
* После этого новое состояние передается обратно в Model,
* где оно становится текущим состоянием.
* */
abstract class Reducer<S : UiState, E : UiEvent>(initialVal: S) {

    private val _state: MutableStateFlow<S> = MutableStateFlow(initialVal)
    val state: StateFlow<S>
        get() = _state


    fun sendEvent(event: E) {
        reduce(_state.value, event)
    }

    fun setState(newState: S) {
        _state.tryEmit(newState)
    }

    abstract fun reduce(oldState: S, event: E)
}
interface UiState

interface UiEvent
