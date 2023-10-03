package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.ui.theme.MyApplicationTheme

class LazyColumnEx : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      MyApplicationTheme {
        // A surface container using the 'background' color from the theme
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
          Greeting5("Android")
        }
      }
    }
  }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Greeting5(name: String, modifier: Modifier = Modifier) {
  LazyColumn() {
    item {
      Text(text = "I am something")
    }
    item {
      Button(onClick = { /*TODO*/ }) {
        Text(text = "i am sign in")
      }
    }
    item {
      Image(
        painterResource(id = android.R.drawable.star_big_on),
        contentDescription = ""
      )
    }
    items(listOf(1,2,3)) {
      Text("Item $it", Modifier.animateItemPlacement())
    }
  }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview7() {
  MyApplicationTheme {
    Greeting5("Android")
  }
}