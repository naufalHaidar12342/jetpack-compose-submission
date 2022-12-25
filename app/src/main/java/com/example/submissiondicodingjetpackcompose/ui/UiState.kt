package com.example.submissiondicodingjetpackcompose.ui

sealed class UiState<out T:Any?>{
    object Loading:UiState<Nothing>()
    data class Success<out T:Any>(val data:T): UiState<T>()
    data class Error(val errorMessages:String): UiState<Nothing>()
}
