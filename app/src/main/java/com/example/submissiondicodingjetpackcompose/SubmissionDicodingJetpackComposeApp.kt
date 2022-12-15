package com.example.submissiondicodingjetpackcompose

import androidx.compose.animation.*
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.submissiondicodingjetpackcompose.model.GithubUser
import com.example.submissiondicodingjetpackcompose.model.GithubUserData
import com.example.submissiondicodingjetpackcompose.ui.components.GithubUserItem
import com.example.submissiondicodingjetpackcompose.ui.components.ScrollBackToTop
import com.example.submissiondicodingjetpackcompose.ui.theme.SubmissionDicodingJetpackComposeTheme
import kotlinx.coroutines.launch

@Composable
fun SubmissionDicodingComposeApp(modifier: Modifier=Modifier){

    Box(modifier = modifier) {
        val scope = rememberCoroutineScope()
        val listState = rememberLazyListState()
        val showButton:Boolean by remember {
            derivedStateOf { listState.firstVisibleItemIndex>0 }
        }
        LazyColumn(state = listState){
            items(GithubUserData.githubUsers, key = {it.username}){ item: GithubUser ->
                GithubUserItem(
                    name = item.fullName,
                    username = item.username,
                    avatar = item.profilePicture,
                )
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




@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SubmissionDicodingJetpackComposeTheme {
        SubmissionDicodingComposeApp()
    }
}