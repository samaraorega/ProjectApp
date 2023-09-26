package com.example.clubactivitytracker.ui.theme.pages.signup

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.materialIcon
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.clubactivitytracker.data.AuthRepository
import com.example.clubactivitytracker.navigation.ROUTE_LOGIN
import com.example.clubactivitytracker.navigation.ROUTE_TRAINING
import com.example.clubactivitytracker.ui.theme.ClubActivityTrackerTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignupScreen(navController: NavHostController) {
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {
        var context = LocalContext.current
        Text(
            text = "Sign up here!",
            color = Color.White,
            fontSize = 30.sp,
            fontFamily = FontFamily.SansSerif,
            textDecoration = TextDecoration.Underline,
            fontWeight = FontWeight.Bold)

        var name by remember { mutableStateOf(TextFieldValue("")) }
        var email by remember { mutableStateOf(TextFieldValue("")) }
        var password by remember { mutableStateOf(TextFieldValue("")) }



        OutlinedTextField(
            value = name,
            onValueChange = {name = it},
            label = { Text(text = "Name") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            leadingIcon = {
                Icon(Icons.Default.Person,contentDescription = "Password" )
            }
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = email,
            onValueChange = {email = it},
            label = { Text(text = "Email") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            leadingIcon = {
                Icon(Icons.Default.Email,contentDescription = "Password" )
            }

        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = password,
            onValueChange = {password = it},
            label = {Text(text = "Password")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            leadingIcon = {
                Icon(Icons.Default.Lock,contentDescription = "Password" )
            }
        )


        Spacer(modifier = Modifier.height(40.dp))

        Button(onClick = {
            // ---WRITE SIGNUP LOGIC HERE-------//
            var authRepository = AuthRepository(navController,context)
            authRepository.signup(name.text.trim(), email.text.trim(), password.text.trim())
            navController.navigate(ROUTE_LOGIN)
        }) {
            Text(text = "Sign up!")

        }

        Divider(color = Color.White.copy(alpha = 0.3f),thickness = 1.dp, modifier = Modifier.padding(top = 20.dp))

        Row (verticalAlignment = Alignment.CenterVertically){
            Text(text = "Already have an account?", color = Color.White)
            TextButton(onClick = {
                navController.navigate(ROUTE_LOGIN)
            }) {
                Text(text = "Log in")

            }

        }



    }
}

fun Icon(lock: ImageVector) {
    TODO("Not yet implemented")
}


@Preview
@Composable
fun SignupScreenPreview() {
    ClubActivityTrackerTheme {
        SignupScreen(rememberNavController())
    }
    
}