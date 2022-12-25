package com.example.submissiondicodingjetpackcompose.ui.home

import androidx.compose.animation.*
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.submissiondicodingjetpackcompose.data.GithubUserRepository
import com.example.submissiondicodingjetpackcompose.data.GithubUserViewModel
import com.example.submissiondicodingjetpackcompose.data.GithubUserViewModelFactory
import com.example.submissiondicodingjetpackcompose.model.GithubUser
import com.example.submissiondicodingjetpackcompose.ui.components.GithubUserItem
import com.example.submissiondicodingjetpackcompose.ui.components.ScrollBackToTop
import com.example.submissiondicodingjetpackcompose.ui.components.UserHeader
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeContent(
    githubUsers:List<GithubUser>,
    modifier: Modifier=Modifier,
    viewModel: GithubUserViewModel = viewModel(
        factory = GithubUserViewModelFactory(
            GithubUserRepository()
        )
    ),
) {
    val groupedUsers by viewModel.groupedGithubUser.collectAsState()
    Box(modifier = modifier) {
        val scope = rememberCoroutineScope()
        val listState = rememberLazyListState()
        val showButton:Boolean by remember {
            derivedStateOf { listState.firstVisibleItemIndex>0 }
        }
        LazyColumn(state = listState){
            groupedUsers.forEach { (initial, groupedName)->
                stickyHeader {
                    UserHeader(userFirstLetter = initial)
                }

                items(groupedName, key = {it.username}){ item: GithubUser ->
                    GithubUserItem(
                        name = item.fullName,
                        username = item.username,
                        avatar = item.profilePicture,
                    )
                }
            }


        }
        AnimatedVisibility(
            visible = showButton,
            enter = fadeIn()+ slideInVertically(),
            exit = fadeOut()+ slideOutVertically(),
            modifier = Modifier
                .padding(bottom = 30.dp)
                .align(Alignment.BottomCenter)
        ) {
            ScrollBackToTop(onButtonClicked = {
                scope.launch {
                    listState.animateScrollToItem(index = 0)


                }
            })
        }
    }

}