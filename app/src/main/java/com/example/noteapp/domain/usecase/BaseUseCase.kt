package com.example.noteapp.domain.usecase

abstract class BaseUseCase<T> {
    abstract suspend fun invoke(): T
}