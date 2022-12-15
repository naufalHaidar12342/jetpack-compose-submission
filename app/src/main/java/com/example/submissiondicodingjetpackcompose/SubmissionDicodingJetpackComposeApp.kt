package com.example.submissiondicodingjetpackcompose

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.submissiondicodingjetpackcompose.ui.theme.SubmissionDicodingJetpackComposeTheme

@Composable
fun SubmissionDicodingComposeApp(modifier: Modifier=Modifier){

}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SubmissionDicodingJetpackComposeTheme {
        Greeting("Android")
    }
}