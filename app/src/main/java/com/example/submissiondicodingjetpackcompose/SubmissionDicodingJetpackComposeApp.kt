package com.example.submissiondicodingjetpackcompose

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.submissiondicodingjetpackcompose.data.GithubUserRepository
import com.example.submissiondicodingjetpackcompose.data.GithubUserViewModel
import com.example.submissiondicodingjetpackcompose.data.GithubUserViewModelFactory
import com.example.submissiondicodingjetpackcompose.ui.components.BottomNavigationBar
import com.example.submissiondicodingjetpackcompose.ui.navigation.Menu
import com.example.submissiondicodingjetpackcompose.ui.screen.HomeScreen
import com.example.submissiondicodingjetpackcompose.ui.screen.ProfileScreen
import com.example.submissiondicodingjetpackcompose.ui.theme.SubmissionDicodingJetpackComposeTheme

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SubmissionDicodingComposeApp(
    modifier: Modifier=Modifier,
    viewModel: GithubUserViewModel= viewModel(
        factory = GithubUserViewModelFactory(
        GithubUserRepository())
    ),
    navHostController: NavHostController= rememberNavController()
){
    val groupedUsers by viewModel.groupedGithubUser.collectAsState()
    Scaffold(
        bottomBar = { BottomNavigationBar(navController = navHostController)}
    ) { innerPadding->
        NavHost(
            navController = navHostController,
            startDestination = Menu.Home.route,
            modifier = Modifier.padding(innerPadding)
        ){
            composable(Menu.Home.route){
                HomeScreen()
            }
            composable(Menu.Profile.route){
                ProfileScreen()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SubmissionDicodingJetpackComposeTheme {
        SubmissionDicodingComposeApp()
    }
}