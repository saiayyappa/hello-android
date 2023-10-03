package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myapplication.ui.theme.MyApplicationTheme
import myViewModel

class ViewModelEx : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      MyApplicationTheme {
        // A surface container using the 'background' color from the theme
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
          Greeting9("Android")
        }
      }
    }
  }
}

@Composable
fun Greeting9(name: String, modifier: Modifier = Modifier) {
  val viewModel = viewModel<myViewModel>()
  val count = viewModel.count

  Column {
    MyButton(currentCount = count) {
      viewModel.increaseCount()
    }
  }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview9() {
  MyApplicationTheme {
    Greeting9("Android")
  }
}

@Composable
fun MyButton(currentCount: Int, updateCount: (Int) -> Unit) {
  Button(
    onClick = {
      updateCount(currentCount)
    },
    contentPadding = PaddingValues(16.dp),
    modifier = Modifier.fillMaxWidth()
//    border = BorderStroke(10.dp, Color.Black),
//    colors = ButtonDefaults.textButtonColors(
//      contentColor = Color.White
//    )
  ) {
    Text(
      "Count is : $currentCount",
      style = MaterialTheme.typography.bodyLarge,
      modifier = Modifier.padding(5.dp)
    )
  }
}