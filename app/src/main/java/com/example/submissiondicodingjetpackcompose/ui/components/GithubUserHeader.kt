package com.example.submissiondicodingjetpackcompose.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp


@Composable
fun UserHeader(userFirstLetter:Char,modifier: Modifier=Modifier){
    Surface(color = MaterialTheme.colors.primary, modifier = modifier) {
        Text(
            text = userFirstLetter.toString(),
            fontWeight = FontWeight.Bold,
            color = Color.White,
            textAlign = TextAlign.Center,
            modifier=Modifier.fillMaxWidth().padding(8.dp)
        )
    }
}