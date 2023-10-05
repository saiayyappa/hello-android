package roomdbex

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import roomdbex.ui.theme.MyApplicationTheme

class RoomDBEx : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      MyApplicationTheme {
        // A surface container using the 'background' color from the theme
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
          RoomDBExSample()
        }
      }
    }
  }
}

@Composable
fun RoomDBExSample() {
  Column(
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally,
    modifier = Modifier
      .padding(16.dp)
      .fillMaxSize()
      .verticalScroll(rememberScrollState())
  ) {
    val applicationContext = LocalContext.current
    val database = UserDatabase.getDatabase(applicationContext)
    val userDao = database.userDao()
    var saveState by remember { mutableStateOf(false) }
    var retrieveState by remember { mutableStateOf(false) }
    var deleteState by remember { mutableStateOf(false) }

    var username by remember { mutableStateOf("") }
    var bloodGroup by remember { mutableStateOf("") }
    var deleteId by remember { mutableStateOf("") }
    var userData by remember {
      mutableStateOf<List<User>?>(null)
    }

    val scope = rememberCoroutineScope()
    val modifier = Modifier.padding(
      10.dp, 16.dp
    )

    if (saveState) {
      LaunchedEffect(scope) {
        try {
          userDao.insertUserInfo(
            User(
              firstName = username, bloodGroup = bloodGroup
            )
          )
          Toast.makeText(applicationContext, "Saved to db", Toast.LENGTH_SHORT).show()
        } catch (ex: Exception) {
          Toast.makeText(applicationContext, "Saved to db failed", Toast.LENGTH_SHORT).show()
        }
      }
    }

    if (retrieveState) {
      LaunchedEffect(scope) {
        try {
          userData = userDao.getUserInfo()

        } catch (ex: Exception) {
          println("user info retrieve failed")
        }
      }
    }

    if (deleteState) {
      LaunchedEffect(scope) {
        try {
          userDao.deleteUserInfo(deleteId.toInt())
        } catch (ex: Exception) {
          println("user info delete failed")
        }
      }
    }

    OutlinedTextField(value = username, onValueChange = { username = it }, modifier, placeholder = {
      Text(text = "Enter username")
    })
    OutlinedTextField(value = bloodGroup,
      onValueChange = { bloodGroup = it },
      modifier,
      placeholder = {
        Text(text = "Enter Blood group")
      })
    Button(onClick = {
      saveState = !saveState
      username = ""
      bloodGroup = ""
    }, modifier) {
      Text(text = "Save")
    }
    Button(onClick = { retrieveState = !retrieveState }, modifier) {
      Text(text = "Retrieve")
    }
    if (!userData.isNullOrEmpty()) {
      LazyColumn {
        items(userData!!) {
          Text(text = "\tUsername: ${it.firstName}, BloodGroup: ${it.bloodGroup}  \n\n")
        }
      }
    }
    OutlinedTextField(value = deleteId, onValueChange = { deleteId = it }, modifier, placeholder = {
      Text(text = "Enter id to delete")
    })
    Button(onClick = { deleteState = !deleteState }, modifier) {
      Text(text = "Delete")
    }
  }
}

@Preview(showBackground = true)
@Composable
fun RoomDBExSamplePreview() {
  MyApplicationTheme {
    RoomDBExSample()
  }
}