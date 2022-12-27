package com.example.submissiondicodingjetpackcompose.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.submissiondicodingjetpackcompose.ui.profile.ProfileContent
import com.example.submissiondicodingjetpackcompose.ui.theme.SubmissionDicodingJetpackComposeTheme

@Composable
fun ProfileScreen(
    modifier: Modifier=Modifier
){
    Column(
        modifier = modifier.fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ProfileContent()

    }
}

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview(){
    SubmissionDicodingJetpackComposeTheme {
        ProfileScreen()

    }
}