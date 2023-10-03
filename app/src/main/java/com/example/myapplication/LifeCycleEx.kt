package com.example.myapplication

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.ui.theme.MyApplicationTheme
import java.text.SimpleDateFormat
import java.util.Date

class LifeCycleEx : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      MyApplicationTheme {
        // A surface container using the 'background' color from the theme
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
          Greeting8("Android")
        }
      }
    }
  }

  override fun onPause() {
    super.onPause()

    val formatter = SimpleDateFormat("dd/MM/yyyy hh:mm:ss")

    val dateString = formatter.format(Date(System.currentTimeMillis()))

    Log.d(
      "status whatshappening", "Last seen on "
          + dateString
    )
  }

  override fun onResume() {
    super.onResume()
    Log.d("status whatshappening", "Online")
  }
}

@Composable
fun Greeting8(name: String, modifier: Modifier = Modifier) {
  Text(
    text = "Hello $name!",
    modifier = modifier
  )

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview8() {
  MyApplicationTheme {
    Greeting8("Android")
  }
}