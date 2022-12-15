package com.example.submissiondicodingjetpackcompose

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.submissiondicodingjetpackcompose.model.GithubUser
import com.example.submissiondicodingjetpackcompose.model.GithubUserData

import com.example.submissiondicodingjetpackcompose.ui.components.GithubUserItem
import com.example.submissiondicodingjetpackcompose.ui.theme.SubmissionDicodingJetpackComposeTheme

@Composable
fun SubmissionDicodingComposeApp(modifier: Modifier=Modifier){
    Box(modifier = modifier) {
        LazyColumn(){
            items(GithubUserData.githubUsers, key = {it.username}){ item: GithubUser ->
                GithubUserItem(
                    name = item.fullName,
                    username = item.username,
                    avatar = item.profilePicture,
                )
            }
        }
    }

}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SubmissionDicodingJetpackComposeTheme {
        SubmissionDicodingComposeApp()
    }
}