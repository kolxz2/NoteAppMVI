package com.example.noteapp.presenter.items

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ErrorItem(error:String?, onButtonClicked: ()->Unit) {

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Box(modifier = Modifier
            .clip(RoundedCornerShape(10.dp))
            .background(Color.Gray)
            .padding(vertical = 16.dp, horizontal = 24.dp)
        ){
            Text(text = error ?: "Oh .. something went wrong",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
            )
        }
        Button(onClick = {
            onButtonClicked()
        }) {
            Text(text = "Refresh")
        }


    }
}