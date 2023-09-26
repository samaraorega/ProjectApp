@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)

package com.example.clubactivitytracker.ui.theme.pages.login

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.clubactivitytracker.R
import com.example.clubactivitytracker.data.AuthRepository

import com.example.clubactivitytracker.ui.theme.ClubActivityTrackerTheme

@Composable
fun LoginScreen(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {

        var context = LocalContext.current
        Text(
            text = "Login here!",
            color = Color.White,
            fontSize = 30.sp,
            fontFamily = FontFamily.SansSerif,
            textDecoration = TextDecoration.Underline,
            fontWeight = FontWeight.Bold)

        var name by remember { mutableStateOf(TextFieldValue(""))}
        var email by remember { mutableStateOf(TextFieldValue(""))}
        var password by remember { mutableStateOf(TextFieldValue(""))}

        OutlinedTextField(
            value = name,
            onValueChange = {name = it},
            label = {Text(text = "Name")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            leadingIcon = {
                Icon(Icons.Default.Person,contentDescription = "Name" )
            }

        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = email,
            onValueChange = {email = it},
            label = {Text(text = "Email")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            leadingIcon = {
                Icon(Icons.Default.Email,contentDescription = "Email" )
            }

        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = password,
            onValueChange = {password = it} ,
            label = {Text(text = "Password")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            leadingIcon = {
                Icon(Icons.Default.Lock,contentDescription = "Password" )
            }
        )


        Spacer(modifier = Modifier.height(20.dp))
        
        Button(onClick = {
            // ---WRITE LOGIN LOGIC HERE-------//
            var authRepository = AuthRepository(navController,context)
            authRepository.login(name.text, email.text, password.text)
        }) {
           Text(text = "LOGIN")
        }





    }
}

@Preview
@Composable
fun LoginScreenPreview() {
    ClubActivityTrackerTheme {
        LoginScreen(rememberNavController())
    ClubActivityTrackerTheme {
        LoginScreen(rememberNavController())
    }

    }

}