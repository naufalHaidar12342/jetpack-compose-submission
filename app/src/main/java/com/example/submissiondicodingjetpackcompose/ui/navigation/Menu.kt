package com.example.submissiondicodingjetpackcompose.ui.navigation

sealed class Menu(val route:String){
    object Home:Menu("home")
    object Profile:Menu("profile")
}
