package com.example.submissiondicodingjetpackcompose.data

import com.example.submissiondicodingjetpackcompose.model.GithubUser
import com.example.submissiondicodingjetpackcompose.model.GithubUserData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class GithubUserRepository{
    private val githubUsers= mutableListOf<GithubUser>()
    init {
        if (githubUsers.isEmpty()){
            GithubUserData.githubUsers.forEach {
                githubUsers.add(
                    GithubUser(
                        fullName = it.fullName,
                        username = it.username,
                        company = it.company,
                        location = it.location,
                        profilePicture = it.profilePicture
                    )
                )
            }
        }
    }
    fun getGithubUser():List<GithubUser> = GithubUserData.githubUsers
    fun getAllGithubUser():Flow<List<GithubUser>> = flowOf(githubUsers)
    fun getGithubUserByUsername(username: String): GithubUser {
        return githubUsers.first { it.username==username }
    }

    companion object{
        @Volatile
        private var instance:GithubUserRepository? =null

        fun getInstance(): GithubUserRepository {
            return instance?: synchronized(this){
                GithubUserRepository().apply {
                    instance=this
                }
            }
            
        }
    }
}