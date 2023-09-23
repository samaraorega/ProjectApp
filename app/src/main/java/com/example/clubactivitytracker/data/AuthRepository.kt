package com.example.clubactivitytracker.data


import android.app.ProgressDialog
import android.content.Context
import android.widget.ProgressBar
import android.widget.Toast
import androidx.navigation.NavHostController
import com.example.clubactivitytracker.models.User
import com.example.clubactivitytracker.navigation.ROUTE_HOME
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase


class AuthRepository(var navController: NavHostController, var context: Context) {
    var mAuth: FirebaseAuth
    var progress: ProgressDialog

    init {
        mAuth = FirebaseAuth.getInstance()
        progress = ProgressDialog(context)
        progress.setTitle("Loading")
        progress.setMessage("Please wait..")
    }

    fun login(name: String, email: String, password: String) {
        progress.show()
        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
            progress.dismiss()
            if (it.isSuccessful) {
                Toast.makeText(context, "Log in was successful", Toast.LENGTH_SHORT).show()
                navController.navigate(ROUTE_HOME)
            }
        }
    }

    fun signup(name: String, email: String, password: String) {
        progress.show()
        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
            progress.dismiss()
            if (it.isSuccessful) {
                var userId = mAuth.currentUser!!.uid
                var userData = User(name, email, password, userId)
                var regRef = FirebaseDatabase.getInstance().getReference()
                    .child("User's/$userId")
                regRef.setValue(userData).addOnCompleteListener {
                    if (it.isSuccessful) {
                        Toast.makeText(context, "Sign up successful", Toast.LENGTH_SHORT).show()
                        navController.navigate(ROUTE_HOME)
                    }
                }
            }
        }

    }

}




