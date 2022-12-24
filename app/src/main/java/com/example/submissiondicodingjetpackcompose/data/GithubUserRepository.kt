package com.example.submissiondicodingjetpackcompose.data

import com.example.submissiondicodingjetpackcompose.model.GithubUser
import com.example.submissiondicodingjetpackcompose.model.GithubUserData

class GithubUserRepository {
    fun getGithubUser():List<GithubUser> = GithubUserData.githubUsers
}