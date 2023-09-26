package com.example.clubactivitytracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.clubactivitytracker.navigation.AppNavHost
import com.example.clubactivitytracker.navigation.ROUTE_LOGIN
import com.example.clubactivitytracker.ui.theme.ClubActivityTrackerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ClubActivityTrackerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DemoScreen(rememberNavController())
                    AppNavHost()



                }
            }
        }
    }
}

@Composable
fun  DemoScreen(navController:NavHostController){
    Box(modifier = Modifier.fillMaxSize()){
       Image(
           painter = painterResource(id = R.drawable.dem2),
           contentDescription = "Demo background",
           contentScale = ContentScale.FillBounds,
           modifier = Modifier.matchParentSize())
    }


}

@Preview(showBackground = true)
@Composable
fun DemoScreenPreview(){
    DemoScreen(rememberNavController())

}