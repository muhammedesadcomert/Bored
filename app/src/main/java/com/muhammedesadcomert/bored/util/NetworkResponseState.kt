package com.muhammedesadcomert.bored.util

sealed interface NetworkResponseState<out T> {
    data class Success<T>(val data: T) : NetworkResponseState<T>
    data class Error(val errorMessage: String) : NetworkResponseState<Nothing>
    data object Loading : NetworkResponseState<Nothing>
}