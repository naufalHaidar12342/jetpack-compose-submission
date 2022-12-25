package com.example.submissiondicodingjetpackcompose.data

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.submissiondicodingjetpackcompose.model.GithubUser
import com.example.submissiondicodingjetpackcompose.ui.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class GithubUserViewModel(private val repository: GithubUserRepository):ViewModel() {
    private val _uiState:MutableStateFlow<UiState<List<GithubUser>>> = MutableStateFlow(UiState.Loading)
    val uiState:StateFlow<UiState<List<GithubUser>>> get() = _uiState

    private val _groupedGithubUser = MutableStateFlow(
        repository.getGithubUser()
            .sortedBy { it.fullName }
            .groupBy { it.fullName[0] }
    )
    val groupedGithubUser: StateFlow<Map<Char, List<GithubUser>>> get() = _groupedGithubUser

    fun getAllGithubUser(){
        viewModelScope.launch {
            repository.getAllGithubUser()
                .catch {
                    _uiState.value= UiState.Error(it.message.toString())
                }
                .collect {
                    _uiState.value=UiState.Success(it)
                }
        }
    }
}