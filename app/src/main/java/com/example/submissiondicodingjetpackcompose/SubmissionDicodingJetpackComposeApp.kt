package com.example.submissiondicodingjetpackcompose

import androidx.compose.animation.*
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.submissiondicodingjetpackcompose.data.GithubUserRepository
import com.example.submissiondicodingjetpackcompose.data.GithubUserViewModel
import com.example.submissiondicodingjetpackcompose.data.GithubUserViewModelFactory
import com.example.submissiondicodingjetpackcompose.model.GithubUser
import com.example.submissiondicodingjetpackcompose.ui.components.BottomNavigationBar
import com.example.submissiondicodingjetpackcompose.ui.components.GithubUserItem
import com.example.submissiondicodingjetpackcompose.ui.components.ScrollBackToTop
import com.example.submissiondicodingjetpackcompose.ui.components.UserHeader
import com.example.submissiondicodingjetpackcompose.ui.navigation.Menu

import com.example.submissiondicodingjetpackcompose.ui.screen.HomeScreen
import com.example.submissiondicodingjetpackcompose.ui.screen.ProfileScreen
import com.example.submissiondicodingjetpackcompose.ui.theme.SubmissionDicodingJetpackComposeTheme
import kotlinx.coroutines.launch

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


@Composable
fun Content(
    modifier: Modifier=Modifier,
    viewModel: GithubUserViewModel= viewModel(
    factory = GithubUserViewModelFactory(
        GithubUserRepository())
)){
//    Box(modifier = modifier) {
//        val scope = rememberCoroutineScope()
//        val listState = rememberLazyListState()
//        val showButton:Boolean by remember {
//            derivedStateOf { listState.firstVisibleItemIndex>0 }
//        }
//        LazyColumn(state = listState){
//            groupedUsers.forEach { (initial, groupedName)->
//                stickyHeader {
//                    UserHeader(userFirstLetter = initial)
//                }
//
//                items(groupedName, key = {it.username}){ item: GithubUser ->
//                    GithubUserItem(
//                        name = item.fullName,
//                        username = item.username,
//                        avatar = item.profilePicture,
//                    )
//                }
//            }
//
//
//        }
//        AnimatedVisibility(
//            visible = showButton,
//            enter = fadeIn()+ slideInVertically(),
//            exit = fadeOut()+ slideOutVertically(),
//            modifier = Modifier
//                .padding(bottom = 30.dp)
//                .align(Alignment.BottomCenter)
//        ) {
//            ScrollBackToTop(onButtonClicked = {
//                scope.launch {
//                    listState.animateScrollToItem(index = 0)
//
//
//                }
//            })
//        }
//    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SubmissionDicodingJetpackComposeTheme {
        SubmissionDicodingComposeApp()
    }
}