package com.example.submissiondicodingjetpackcompose.ui.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.submissiondicodingjetpackcompose.data.DetailGithubUserViewModel
import com.example.submissiondicodingjetpackcompose.data.GithubUserViewModelFactory
import com.example.submissiondicodingjetpackcompose.injection.RepositoryInjection
import com.example.submissiondicodingjetpackcompose.ui.UiState
import com.example.submissiondicodingjetpackcompose.ui.detail.DetailContent

@Composable
fun DetailScreen(
    githubUsername: String,
    viewModel: DetailGithubUserViewModel = viewModel(
        factory = GithubUserViewModelFactory(
            RepositoryInjection.provideRepository()
        )
    ),
    navigateBack:()-> Unit
){
    viewModel.detailUiState.collectAsState(initial = UiState.Loading).value.let { detailState->
        when(detailState){

            is UiState.Loading -> {
                viewModel.getUserByUsername(githubUsername)
            }

            is UiState.Success -> {
                val data=detailState.data
                DetailContent(
                    githubUserProfile = data.profilePicture,
                    githubUsername = data.username,
                    githubUserFullname = data.fullName,
                    userLocation = data.location,
                    userCompany = data.company,
                    onBackClick = navigateBack
                )
            }

            is UiState.Error -> {}

        }
    }
    
}