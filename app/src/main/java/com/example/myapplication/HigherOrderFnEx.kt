package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme

class HigherOrderFnEx : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      MyApplicationTheme {
        // A surface container using the 'background' color from the theme
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
          Greeting4("Android")
        }
      }
    }
  }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Greeting4(name: String, modifier: Modifier = Modifier) {
  Column(
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally,
    modifier = Modifier.fillMaxSize()
  ) {
    var greetingProvider by remember { mutableStateOf(::getDefaultGreeting) }
    TextField(value = greetingProvider(), onValueChange = {})
    Button(
      onClick = {
        greetingProvider =
          if (greetingProvider == ::getDefaultGreeting) {
            ::getCustomGreeting
          } else {
            ::getDefaultGreeting
          }
      }
    ) {
      Icon(imageVector = Icons.Default.Send, contentDescription = null)
      Spacer(modifier = Modifier.width(8.dp))
      Text("Toggle Greeting")
    }
  }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview4() {
  MyApplicationTheme {
    Greeting4("Android")
  }
}

// Default greeting provider
private fun getDefaultGreeting(): String {
  return "Hello, World!"
}

// Custom greeting provider
private fun getCustomGreeting(): String {
  return "Greetings from Jetpack Compose!"
}