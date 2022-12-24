package com.example.submissiondicodingjetpackcompose.data

import androidx.lifecycle.ViewModel
import com.example.submissiondicodingjetpackcompose.model.GithubUser
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class GithubUserViewModel(val repository: GithubUserRepository):ViewModel() {
    private val _groupedGithubUser = MutableStateFlow(
        repository.getGithubUser()
            .sortedBy { it.fullName }
            .groupBy { it.fullName[0] }
    )
    val groupedGithubUser: StateFlow<Map<Char, List<GithubUser>>> get() = _groupedGithubUser
}