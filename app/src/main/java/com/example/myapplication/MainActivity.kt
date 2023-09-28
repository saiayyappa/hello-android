package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
  @OptIn(ExperimentalMaterial3Api::class)
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      MyApplicationTheme {
        // A surface container using the 'background' color from the theme
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
//          Greeting("Android")
          Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(start = 20.dp, end = 20.dp)
          ) {
            var a by remember {
              mutableStateOf("")
            }
            var b by remember {
              mutableStateOf("")
            }
            var c by remember {
              mutableStateOf("")
            }
            var d by remember {
              mutableStateOf("")
            }

//            Image(painterResource(id = R.drawable.car), contentDescription = "")

            Text(
              text = "Sign Up",
              fontSize = 32.sp,
              color = Color.DarkGray,
              textAlign = TextAlign.Start,
              modifier = Modifier.fillMaxWidth()
            )

            Text(
              text = "It's quick and easy",
              fontSize = 24.sp,
              color = Color.DarkGray,
              textAlign = TextAlign.Start,
              modifier = Modifier.fillMaxWidth()
            )


            TextField(value = a,
              onValueChange = { a = it },
              Modifier
                .fillMaxWidth()
                .padding(top = 20.dp, bottom = 20.dp),
              placeholder = {
                Text(
                  text = "First name"
                )
              })
            TextField(value = b,
              onValueChange = { b = it },
              Modifier
                .fillMaxWidth()
                .padding(top = 20.dp, bottom = 20.dp),
              placeholder = {
                Text(
                  text = "Surname"
                )
              })

            TextField(value = c,
              onValueChange = { c = it },
              Modifier
                .fillMaxWidth()
                .padding(top = 20.dp, bottom = 20.dp),
              placeholder = {
                Text(
                  text = "Mobile number or email address"
                )
              })
            TextField(value = d,
              onValueChange = { d = it },
              Modifier
                .fillMaxWidth()
                .padding(top = 20.dp, bottom = 20.dp),
              placeholder = {
                Text(
                  text = "New password"
                )
              })

            Text(
              text = "People who use our service may have uploaded your contact information to Facebook.",
              fontSize = 14.sp,
              color = Color.DarkGray,
              textAlign = TextAlign.Start,
              modifier = Modifier.fillMaxWidth()
            )

//            Text(
//              text = "Username",
//              fontSize = 18.sp,
//              textAlign = TextAlign.Start,
//              color = Color.DarkGray,
//              modifier = Modifier
//                .fillMaxWidth()
//                .padding(top = 20.dp)
//            )
//            TextField(value = a, onValueChange = { a = it }, Modifier.fillMaxWidth(), placeholder = { Text(
//              text = "Enter your name"
//            )})
//
//            Text(
//              text = "Password",
//              fontSize = 18.sp,
//              textAlign = TextAlign.Start,
//              color = Color.DarkGray,
//              modifier = Modifier
//                .fillMaxWidth()
//                .padding(top = 20.dp)
//            )
//            TextField(value = b, onValueChange = { b = it }, Modifier.fillMaxWidth(), placeholder = { Text(
//              text = "Enter your password"
//            )})

            Row(
              horizontalArrangement = Arrangement.SpaceEvenly,
              modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp)
            ) {
//              Button(onClick = { }, colors = ButtonDefaults.buttonColors(Color.DarkGray)) {
//                Text(text = "Sign In")
//              }
              Button(onClick = { }, colors = ButtonDefaults.buttonColors(Color.Green)) {
                Text(text = "Sign Up", color = Color.White, fontSize = 18.sp)
              }
            }
          }
        }
      }
    }
  }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun FbScreen() {
  var a by remember {
    mutableStateOf("")
  }
  var b by remember {
    mutableStateOf("")
  }
  var c by remember {
    mutableStateOf("")
  }
  var d by remember {
    mutableStateOf("")
  }
  Column(
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally,
    modifier = Modifier
      .padding(start = 20.dp, end = 20.dp)
      .fillMaxSize()
  ) {
    Text(
      text = "Sign Up",
      fontSize = 32.sp,
      color = Color.Black,
      textAlign = TextAlign.Start,
      modifier = Modifier.fillMaxWidth(),
      fontWeight = FontWeight.Bold
    )

    Text(
      text = "It's quick and easy",
      fontSize = 24.sp,
      color = Color.DarkGray,
      textAlign = TextAlign.Start,
      modifier = Modifier.fillMaxWidth()
    )

    Divider()

    Row(
      horizontalArrangement = Arrangement.SpaceEvenly,
      modifier = Modifier
        .fillMaxWidth()
        .padding(2.dp)
    ) {
      TextField(value = a,
        onValueChange = { a = it },
        placeholder = { Text(text = "First name") },
        modifier = Modifier
          .padding(top = 10.dp, bottom = 10.dp, end = 5.dp)
          .weight(1f)
//          .border(1.dp ,Color.LightGray, RoundedCornerShape(10.dp))
      )
      TextField(value = b,
        onValueChange = { b = it },
        placeholder = { Text(text = "Surname") },
        modifier = Modifier
          .padding(top = 10.dp, bottom = 10.dp, start = 5.dp)
          .weight(1f)
      )
    }

    TextField(value = c,
      onValueChange = { c = it },
      Modifier
        .fillMaxWidth()
        .padding(top = 10.dp, bottom = 10.dp),
      placeholder = {
        Text(
          text = "Mobile number or email address"
        )
      })
    TextField(value = d,
      onValueChange = { d = it },
      Modifier
        .fillMaxWidth()
        .padding(top = 10.dp, bottom = 10.dp),
      placeholder = {
        Text(
          text = "New password"
        )
      })

    Text(
      text = "People who use our service may have uploaded your contact information to Facebook.",
      fontSize = 14.sp,
      color = Color.DarkGray,
      textAlign = TextAlign.Start,
      modifier = Modifier.fillMaxWidth()
    )
    Row(
      horizontalArrangement = Arrangement.SpaceEvenly,
      modifier = Modifier
        .fillMaxWidth()
        .padding(top = 20.dp)
    ) {
      Button(onClick = { }, colors = ButtonDefaults.buttonColors(Color(0xff42b72a))) {
        Text(text = "Sign Up", color = Color.White, fontSize = 18.sp)
      }
    }
  }
}