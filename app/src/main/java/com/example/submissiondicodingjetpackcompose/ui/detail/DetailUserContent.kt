package com.example.submissiondicodingjetpackcompose.ui.detail

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
fun DetailContent(
    modifier: Modifier=Modifier,
    githubUserProfile:Int,
    githubUsername:String,
    githubUserFullname:String,
    userLocation:String,
    userCompany:String,
    onBackClick:()->Unit
){
    Column(
        modifier = modifier
            .fillMaxHeight(1f)
            .fillMaxWidth(1f)
    ) {
        Column(
            modifier=modifier.fillMaxHeight().fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AsyncImage(
                model = ImageRequest
                    .Builder(LocalContext.current)
                    .data(githubUserProfile)
                    .build(),
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = modifier
                    .padding(8.dp)
                    .size(120.dp)
                    .clip(CircleShape)
            )
            Spacer(modifier = modifier.padding(top = 2.dp))
            Text(
                text = githubUsername,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Monospace,
                fontSize = 18.sp
            )
            Text(
                text = githubUserFullname,
                fontWeight = FontWeight.Medium,
                fontFamily = FontFamily.SansSerif,
                fontSize = 16.sp
            )
            Spacer(modifier = modifier.padding(bottom = 6.dp))
            Row(modifier = modifier) {
                Icon(
                    imageVector = Icons.Filled.Home,
                    contentDescription = "icon of location on map"
                )
                Text(
                    text = userCompany,
                    fontWeight = FontWeight.Medium,
                    fontFamily = FontFamily.SansSerif,
                    fontSize = 14.sp
                )

            }
            Row(modifier = modifier) {
                Icon(
                    imageVector = Icons.Filled.LocationOn,
                    contentDescription = "icon of location on map"
                )
                Text(
                    text = userLocation,
                    fontWeight = FontWeight.Medium,
                    fontFamily = FontFamily.SansSerif,
                    fontSize = 14.sp
                )
            }


        }
        }

}

@Preview(showBackground = true)
@Composable
fun DetailContentPreview(){
    SubmissionDicodingJetpackComposeTheme() {
        DetailContent(
            githubUserProfile = R.drawable.user1,
            githubUsername = "@naufalHaidar12342",
            githubUserFullname = "Naufal Haidar",
            userLocation = "Indonesia",
            userCompany = "Faculty of Engineering Udinus"
        ) {
            
        }
    }
}