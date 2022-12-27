package com.example.submissiondicodingjetpackcompose.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.submissiondicodingjetpackcompose.R
import com.example.submissiondicodingjetpackcompose.ui.theme.SubmissionDicodingJetpackComposeTheme

@Composable
fun GithubUserItem(
    name:String,
    username:String,
    avatar:Int,
    modifier: Modifier=Modifier,
){
    Card(
        modifier = modifier
            .padding(12.dp)
            .shadow(3.dp)
            .fillMaxWidth()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(6.dp)
        ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(avatar)
                .build(),
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .padding(10.dp)
                .size(100.dp)
                .clip(CircleShape)
        )
        Spacer(modifier = Modifier.padding(4.dp))
        Column {
            Text(
                text = username,
                fontFamily = FontFamily.SansSerif,
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.padding(4.dp))
            Text(
                text = name,
                fontSize = 24.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
    }

}

@Preview(showBackground = true)
@Composable
fun GithubUserCardPreview(){
    SubmissionDicodingJetpackComposeTheme() {
        GithubUserItem(
            name = "Jake Wharton",
            avatar = R.drawable.user1,
            username = "@JakeWharton"
        )
    }
}