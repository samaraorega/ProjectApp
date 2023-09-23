package com.example.clubactivitytracker.ui.theme.pages.firstaid

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.clubactivitytracker.ui.theme.ClubActivityTrackerTheme

@Composable
fun FirstAidScreen(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "First Aid Skills",
            color = Color.Black,
            fontSize = 30.sp,
            fontFamily = FontFamily.Cursive,
            textDecoration = TextDecoration.Underline,
            fontWeight = FontWeight.Bold
        )
        Button(onClick = { /*TODO*/ }) {
            Text(text = "Sprained-ankle")
        }
        Button(onClick = { /*TODO*/ }) {
            Text(text = "Broken body part")

        }
        Button(onClick = { /*TODO*/ }) {
            Text(text = "Nose-bleeding")

        }
        Button(onClick = { /*TODO*/ }) {
            Text(text = "Snake-Bite")

        }
    }
}

@Preview
@Composable
fun FirstAidScreenPreview() {
    ClubActivityTrackerTheme {
        FirstAidScreen(rememberNavController())
    }
    
}