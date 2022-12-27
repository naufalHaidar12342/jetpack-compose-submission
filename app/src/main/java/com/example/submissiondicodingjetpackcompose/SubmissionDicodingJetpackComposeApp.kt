package com.example.submissiondicodingjetpackcompose

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.submissiondicodingjetpackcompose.ui.components.BottomNavigationBar
import com.example.submissiondicodingjetpackcompose.ui.navigation.Menu
import com.example.submissiondicodingjetpackcompose.ui.screen.DetailScreen
import com.example.submissiondicodingjetpackcompose.ui.screen.HomeScreen
import com.example.submissiondicodingjetpackcompose.ui.screen.ProfileScreen
import com.example.submissiondicodingjetpackcompose.ui.theme.SubmissionDicodingJetpackComposeTheme

@Composable
fun SubmissionDicodingComposeApp(
    navHostController: NavHostController= rememberNavController()
){
    val navBackStackEntry by navHostController.currentBackStackEntryAsState()
    val currentRoute=navBackStackEntry?.destination?.route
    Scaffold(
        bottomBar = {
            if (currentRoute!=Menu.DetailedGithubUser.route){
                BottomNavigationBar(navController = navHostController)
            }
        }
    ) { innerPadding->
        NavHost(
            navController = navHostController,
            startDestination = Menu.Home.route,
            modifier = Modifier.padding(innerPadding)
        ){
            composable(Menu.Home.route){
                HomeScreen(
                    navigateToDetail = { userDetail->
                        navHostController.navigate(
                            Menu.DetailedGithubUser.createRoute(userDetail)
                        )
                    }
                )
            }
            composable(Menu.Profile.route){
                ProfileScreen()
            }
            composable(
                route = Menu.DetailedGithubUser.route,
                arguments = listOf(navArgument("githubUsername"){
                    type= NavType.StringType
                })
            ){
                val receivedGithubUsername=it.arguments?.getString("githubUsername") ?: ""
                DetailScreen(
                    githubUsername = receivedGithubUsername,
                    navigateBack = {
                        navHostController.navigateUp()
                    }
                )
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