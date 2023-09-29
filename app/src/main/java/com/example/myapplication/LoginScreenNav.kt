package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.ui.theme.MyApplicationTheme

class LoginScreenNav : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      MyApplicationTheme {
        // A surface container using the 'background' color from the theme
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
          Greeting7("Android")
        }
      }
    }
  }
}

@Composable
fun Greeting7(name: String, modifier: Modifier = Modifier) {
  val navController = rememberNavController()

  NavHost(navController = navController, startDestination = "login"){
    composable("login"){
      LoginScreen(navController)
    }
    composable("signup"){
      SignUp(navController)
    }
    composable("signin/{username}/{pass}"){
      val x = it.arguments?.getString("username")
      val y = it.arguments?.getString("pass")
      SignIn(navController,x,y)
    }
  }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview6() {
  MyApplicationTheme {
    Greeting7("Android")
  }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(navController: NavHostController) {
  Column {
    var us by remember {
      mutableStateOf("")
    }
    var pw by remember {
      mutableStateOf("")
    }
    Text(text = "Username")
    TextField(value = us, onValueChange ={us=it} )
    Text(text = "Password")
    TextField(value = pw, onValueChange ={pw=it} )

    Row {
      Button(onClick = {
        navController.navigate("signin/$us/$pw")

      }) {
        Text(text = "Sign In")
      }
      Button(onClick = {
        navController.navigate("signup")
      }) {
        Text(text = "Sign Up")
      }
    }
  }
}

@Composable
fun SignUp(navController: NavHostController) {
  Column {
    Text(text = "I am sign up Screen")
  }
}
@Composable
fun SignIn(navController: NavHostController, x: String?, y: String?) {
  Column {
    Text(text = "I am sign in Screen")
    Text(text = "these are the data from Login Screen \n $x \n $y ")
  }
}