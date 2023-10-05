package roomdb

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import roomdb.ui.theme.MyApplicationTheme

class RoomDBEx : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      MyApplicationTheme {
        // A surface container using the 'background' color from the theme
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
          RoomDBExercise("Android")
        }
      }
    }
  }
}

@Composable
fun RoomDBExercise(name: String, modifier: Modifier = Modifier) {
  Text(
    text = "Hello $name!",
    modifier = modifier
  )
  val applicationContext = LocalContext.current
  val database = MyDatabase.getDatabase(applicationContext)
  val myDao = database.myDao()
  var ins by remember { mutableStateOf(false) }

  if (ins) {
    val scope = rememberCoroutineScope()
    LaunchedEffect(scope) {
      try {
        myDao.d(
          TodoItem(
            itemName = "Android session",
            itemDesc = "learning Room Database ",
            isDone = true
          )
        )
      } catch (ex: Exception) {
        println("cancelled")
      }
    }
  }
  Button(onClick = { ins = !ins }) {
    Text(text = "insert new data")
  }
}

@Preview(showBackground = true)
@Composable
fun RoomDBExercisePreview() {
  MyApplicationTheme {
    RoomDBExercise("Android")
  }
}