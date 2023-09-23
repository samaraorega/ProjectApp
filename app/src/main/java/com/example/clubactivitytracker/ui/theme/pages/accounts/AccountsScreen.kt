package com.example.clubactivitytracker.ui.theme.pages.accounts

import android.content.Intent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

import com.example.clubactivitytracker.ui.theme.ClubActivityTrackerTheme


@Composable
fun AccountsScreen(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {
        var context = LocalContext.current
        Text(
            text = "Financial Records",
            color = Color.Black,
            fontSize = 30.sp,
            fontFamily = FontFamily.Cursive,
            textDecoration = TextDecoration.Underline,
            fontWeight = FontWeight.Bold
        )
        Button(onClick = {
            val simToolKitLaunchIntent: Intent? = context.getPackageManager()
                .getLaunchIntentForPackage("com.android.stk")
            if (simToolKitLaunchIntent != null) {
                context.startActivity(simToolKitLaunchIntent)
            }
        }) {
            Text(text = "Make Payment")
        }

    }
}

@Preview
@Composable
fun AccountsScreenPreview() {
    ClubActivityTrackerTheme {
        AccountsScreen(rememberNavController())
    }

}