package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myapplication.ui.theme.MyApplicationTheme

class LiveDataExercise : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      MyApplicationTheme {
        // A surface container using the 'background' color from the theme
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
          LiveDataExerciseSample("Android")
        }
      }
    }
  }
}

class AViewModel : ViewModel() {
  val aLiveData = MutableLiveData<String>()
  fun updateValue(newValue: String): String {
    aLiveData.value = newValue
    return newValue
  }
}

@Composable
fun LiveDataExerciseSample(name: String, modifier: Modifier = Modifier) {
  Column(
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally,
    modifier = Modifier
      .padding(10.dp)
      .fillMaxSize()
  ) {
    var a by remember { mutableStateOf("") }
    val viewModel: AViewModel = viewModel()
    val aLiveData by viewModel.aLiveData.observeAsState("")

    Text(text = "Type value of a -> Live Data")
    OutlinedTextField(value = a, onValueChange = {
      a = it
    })
    Button(onClick = {
      viewModel.updateValue(a)
    }) {
      Text(text = "Set to text field 2")
    }
    Text(text = "Textfield 2")
    OutlinedTextField(value = aLiveData.toString(), onValueChange = {
//      viewModel.updateValue(it)
    })
    Button(onClick = {
      viewModel.updateValue("56")
    }) {
      Text(text = "Set a to 56")
    }
  }
}

@Preview(showBackground = true)
@Composable
fun LivDataExerciseSamplePreview() {
  MyApplicationTheme {
    LiveDataExerciseSample("Android")
  }
}