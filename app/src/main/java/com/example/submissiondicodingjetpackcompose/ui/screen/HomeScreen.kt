package com.example.submissiondicodingjetpackcompose.ui.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.submissiondicodingjetpackcompose.data.GithubUserViewModel
import com.example.submissiondicodingjetpackcompose.data.GithubUserViewModelFactory
import com.example.submissiondicodingjetpackcompose.injection.RepositoryInjection
import com.example.submissiondicodingjetpackcompose.ui.UiState
import com.example.submissiondicodingjetpackcompose.ui.home.HomeContent

@Composable
fun HomeScreen(
    modifier: Modifier=Modifier,
    viewModel:GithubUserViewModel= viewModel(
        factory = GithubUserViewModelFactory(RepositoryInjection.provideRepository())
    )
){
    viewModel.uiState.collectAsState(initial = UiState.Loading).value.let { uiState ->
        when(uiState){
            is UiState.Loading -> {
                viewModel.getAllGithubUser()
            }
            is UiState.Success -> {
                    HomeContent(
                        githubUsers = uiState.data,
                        modifier = modifier
                    )
            }
            is  UiState.Error -> {}
        }
    }
}