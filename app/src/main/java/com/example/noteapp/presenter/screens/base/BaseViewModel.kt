package com.example.noteapp.presenter.screens.base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.Flow


/*
* Базавая модель для отальных ViewModel в проекте с базовыми настройками
 */

// модификатор in. Он делает параметризованный тип контравариантным: он
// может только потребляться, но не может производиться.
abstract class BaseViewModel<S: UiState, in E: UiEvent> :ViewModel(){
    abstract val state: Flow<S>
}