package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme

class SimpleCalc : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      MyApplicationTheme {
        // A surface container using the 'background' color from the theme
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
          Greeting("Android")
        }
      }
    }
  }
}

fun add(a1: Float, a2: Float): Float {
  return a1 + a2
}

fun subtract(a1: Float, a2: Float): Float {
  return a1 - a2
}

fun multiply(a1: Float, a2: Float): Float {
  return a1 * a2
}

fun divide(a1: Float, a2: Float): Float {
  return a1 / a2
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
  Column {
    var a1 by remember {
      mutableStateOf("")
    }
    var a2 by remember {
      mutableStateOf("")
    }
    var a3 by remember {
      mutableStateOf(0f)
    }
    TextField(
      value = a1,
      onValueChange = { a1 = it }
    )
    TextField(
      value = a2,
      onValueChange = { a2 = it }
    )
    Row {
      Button(
        onClick = { a3 = add(a1.toFloat(), a2.toFloat()) },
        colors = ButtonDefaults.buttonColors(Color(0xff42b72a))
      ) {
        Text(text = "+", color = Color.White, fontSize = 18.sp)
      }
      Button(
        onClick = { a3 = subtract(a1.toFloat(), a2.toFloat()) },
        colors = ButtonDefaults.buttonColors(Color(0xff42b72a))
      ) {
        Text(text = "-", color = Color.White, fontSize = 18.sp)
      }
      Button(
        onClick = { a3 = multiply(a1.toFloat(), a2.toFloat()) },
        colors = ButtonDefaults.buttonColors(Color(0xff42b72a))
      ) {
        Text(text = "*", color = Color.White, fontSize = 18.sp)
      }
      Button(
        onClick = { a3 = divide(a1.toFloat(), a2.toFloat()) },
        colors = ButtonDefaults.buttonColors(Color(0xff42b72a))
      ) {
        Text(text = "/", color = Color.White, fontSize = 18.sp)
      }
    }
    Text(text = a3.toString())
  }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
  MyApplicationTheme {
    Greeting("Android")
  }
}