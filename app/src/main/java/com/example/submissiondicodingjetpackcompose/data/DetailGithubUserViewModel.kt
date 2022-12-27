package com.example.submissiondicodingjetpackcompose.data

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.submissiondicodingjetpackcompose.model.GithubUser
import com.example.submissiondicodingjetpackcompose.ui.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DetailGithubUserViewModel(
    private val repository: GithubUserRepository
    ): ViewModel()
{
    private val _detailUiState:MutableStateFlow<UiState<GithubUser>> =
        MutableStateFlow(UiState.Loading)
    val detailUiState:StateFlow<UiState<GithubUser>> get() = _detailUiState

    fun getUserByUsername(githubUsername: String){
        viewModelScope.launch {
            _detailUiState.value= UiState.Loading
            _detailUiState.value= UiState.Success(
                repository.getGithubUserByUsername(githubUsername)
            )
        }

    }
}