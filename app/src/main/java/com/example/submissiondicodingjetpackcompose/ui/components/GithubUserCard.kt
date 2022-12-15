package com.example.submissiondicodingjetpackcompose.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun GithubUserCard(
    name:String,
    avatar:Int,
    modifier: Modifier=Modifier
){
    Card(modifier=modifier.clickable {  }) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            
        }
    }
}