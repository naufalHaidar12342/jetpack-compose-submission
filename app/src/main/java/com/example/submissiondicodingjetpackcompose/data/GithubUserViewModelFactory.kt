package com.example.submissiondicodingjetpackcompose.data

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class GithubUserViewModelFactory(
    val repository: GithubUserRepository
    ):ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(GithubUserViewModel::class.java)){
            return GithubUserViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
    }
}