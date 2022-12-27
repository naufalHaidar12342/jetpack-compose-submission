package com.example.submissiondicodingjetpackcompose.ui.profile

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.submissiondicodingjetpackcompose.model.ProfileData
import com.example.submissiondicodingjetpackcompose.ui.theme.SubmissionDicodingJetpackComposeTheme

@Composable
fun ProfileContent(modifier: Modifier=Modifier){
    Column(
        modifier = modifier
            .padding(12.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(ProfileData.PROFILE_PICTURE)
                .build(),
            contentDescription = "Picture of me as Dicoding student",
            modifier=modifier
                .padding(10.dp)
                .size(200.dp)
                .clip(CircleShape)
        )
        Spacer(modifier = modifier.padding(top = 8.dp))
        Text(
            text = ProfileData.NAME,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = ProfileData.EMAIL,
            fontSize = 24.sp,
            fontFamily = FontFamily.Monospace
        )
        

    }
}

@Preview(showBackground = true)
@Composable
fun ProfileContentPreview(){
    SubmissionDicodingJetpackComposeTheme {
        ProfileContent()
    }
}