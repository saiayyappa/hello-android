package com.example.myapplication

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.layoutId
import com.example.myapplication.ui.theme.MyApplicationTheme

class ConstraintLayoutExample : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      MyApplicationTheme {
        // A surface container using the 'background' color from the theme
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
          Greeting3("Android")
        }
      }
    }
  }
}

@Composable
fun Greeting3(name: String, modifier: Modifier = Modifier) {
  Text(
    text = "Hello $name!",
    modifier = modifier
  )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview3() {
  MyApplicationTheme {
    Greeting3("Android")
  }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun ConstraintSetExample() {

  val constraintSet = ConstraintSet {
    val buttonLogin = createRefFor("buttonLogin")
    val inputUsername = createRefFor("inputUsername")
    val inputPassword = createRefFor("inputPassword")

    constrain(inputUsername) {
      top.linkTo(parent.top, 32.dp)
      start.linkTo(parent.start, 16.dp)
      end.linkTo(parent.end, 16.dp)
    }

    constrain(inputPassword) {
      top.linkTo(inputUsername.bottom, 8.dp)
      start.linkTo(parent.start, 16.dp)
      end.linkTo(parent.end, 16.dp)
    }

    constrain(buttonLogin) {
      top.linkTo(inputPassword.bottom, 16.dp)
      start.linkTo(parent.start, 16.dp)
      end.linkTo(parent.end, 16.dp)
    }

  }
  ConstraintLayout(
    constraintSet, modifier = Modifier
      .fillMaxWidth()
      .height(250.dp)
  ) {
    val context = LocalContext.current
    var username by remember {
      mutableStateOf("")
    }
    var password by remember {
      mutableStateOf("")
    }
    TextField(
      value = username,
      onValueChange = { username = it },
      label = { Text(text = ("Username")) },
      modifier = Modifier.layoutId("inputUsername")
    )

    TextField(
      value = password,
      onValueChange = { password = it },
      label = { Text("Password") },
      visualTransformation = PasswordVisualTransformation(),
      modifier = Modifier.layoutId("inputPassword")
    )

    Button(onClick = {
      Toast.makeText(
        context,
        "Username $username , Password: $password ",
        Toast.LENGTH_SHORT
      ).show()
    }, Modifier.layoutId("buttonLogin")) {
      Text(text = "Login")
    }
  }
}