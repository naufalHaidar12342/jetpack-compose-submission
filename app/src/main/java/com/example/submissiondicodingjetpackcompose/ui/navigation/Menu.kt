package com.example.submissiondicodingjetpackcompose.ui.navigation

sealed class Menu(val route:String){
    object Home:Menu("home")
    object Profile:Menu("profile")
    object DetailedGithubUser:Menu("home/{githubUsername}") {
        fun createRoute(githubUsername: String) = "home/$githubUsername"
    }
}
