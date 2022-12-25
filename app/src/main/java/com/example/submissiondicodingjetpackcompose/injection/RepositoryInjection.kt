package com.example.submissiondicodingjetpackcompose.injection

import com.example.submissiondicodingjetpackcompose.data.GithubUserRepository

object RepositoryInjection {
    fun provideRepository():GithubUserRepository{
        return GithubUserRepository.getInstance()
    }
}