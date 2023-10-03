package com.example.myapplication

import android.Manifest
import android.os.Bundle
import android.telephony.SmsManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.ui.theme.MyApplicationTheme
import createNotification

class NotificationEx : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      MyApplicationTheme {
        // A surface container using the 'background' color from the theme
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
          ShowNotificationExample("Android")
        }
      }
    }
  }
}


@Composable
fun ShowNotificationExample(name: String, modifier: Modifier = Modifier) {
  val applicationContext = LocalContext.current

  val getPermission = rememberLauncherForActivityResult(
    ActivityResultContracts.RequestPermission()
  ) { isGranted ->
    if (isGranted) {
      //permission accepted do somthing
    } else {
      //permission not accepted show message
    }
  }
//i used SideEffect to launch permission request when screen recomposed
//you can call it inside a button click without SideEffect
  SideEffect {
    getPermission.launch(Manifest.permission.SEND_SMS)
  }

  var smsManager: SmsManager = SmsManager.getDefault()

  Column {
    Button(onClick = {
      createNotification(
        title = "Hello",
        description = "Testing android notification",
        applicationContext
      )
      smsManager.sendTextMessage(
        "8526108714", null, "Hi how are u?", null, null
      )
    }) {
      Text(text = "Show notification")
    }
  }
}

@Preview(showBackground = true)
@Composable
fun ShowNotificationExamplePreview() {
  MyApplicationTheme {
    ShowNotificationExample("Android")
  }
}