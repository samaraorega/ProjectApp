package com.example.clubactivitytracker.ui.theme.pages.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.clubactivitytracker.R
import com.example.clubactivitytracker.navigation.ROUTE_ACCOUNTS
import com.example.clubactivitytracker.navigation.ROUTE_EVENTS
import com.example.clubactivitytracker.navigation.ROUTE_FIRST_AID
import com.example.clubactivitytracker.navigation.ROUTE_TRAINING
import com.example.clubactivitytracker.ui.theme.ClubActivityTrackerTheme

@Composable
fun HomeScreen(navController: NavHostController) {
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Welcome newbie!!")

        Spacer(modifier = Modifier.height(20.dp))
        

            Image(
                modifier= Modifier.size(100.dp),
                painter = painterResource(id = R.drawable.calendar), contentDescription = null)
            Button(onClick = {
                navController.navigate(ROUTE_EVENTS)
            }) {
                Text(text = "Events")}

            Spacer(modifier = Modifier.width(20.dp))

            Image(
                modifier= Modifier.size(100.dp),
                painter = painterResource(id = R.drawable.money), contentDescription = null)
                Button(onClick = {
                    navController.navigate(ROUTE_ACCOUNTS)
                }) {
                    Text(text = "Make Contribution")}



        Spacer(modifier = Modifier.height(20.dp))

        
            Image(
                modifier= Modifier.size(100.dp),
                painter = painterResource(id = R.drawable.strategy), contentDescription = null)
            Button(onClick = {
                navController.navigate(ROUTE_TRAINING)
            }) {
                Text(text = "Training Schedule")}

            Spacer(modifier = Modifier.width(20.dp))

            Image(
                modifier= Modifier.size(100.dp),
                painter = painterResource(id = R.drawable.firstaidkit), contentDescription = null)
                Button(onClick = {
                    navController.navigate(ROUTE_FIRST_AID)
                }) {
                    Text(text = "First Aid")}



        
        
        
        
        }


    }

@Preview
@Composable
fun HomeScreenPreview() {
    ClubActivityTrackerTheme {
        HomeScreen(rememberNavController())
    }

}