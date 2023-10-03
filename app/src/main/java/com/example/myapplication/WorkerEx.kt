package com.example.myapplication

import MyWorker
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.work.Constraints
import androidx.work.Data
import androidx.work.NetworkType
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager
import com.example.myapplication.ui.theme.MyApplicationTheme

class WorkerEx : ComponentActivity() {
  private lateinit var workManager: WorkManager
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      MyApplicationTheme {
        // A surface container using the 'background' color from the theme
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
          var stats by remember {
            mutableStateOf("")
          }
          // what is the work ? = show notification
          // what is the condition = constrains
          // periodic or onetime? = onetime
          workManager = WorkManager.getInstance(applicationContext)

          val powerConstraint =
            Constraints.Builder().setRequiredNetworkType(networkType = NetworkType.NOT_ROAMING)
              .setRequiresCharging(true).build()
          val taskData = Data.Builder().putString("MESSAGE_STATUS", "Notify Done.").build()


          //PeriodicWorkRequest
          val request =
            OneTimeWorkRequest.Builder(MyWorker::class.java).setConstraints(powerConstraint).build()

          var bt by remember { mutableStateOf(false) }

          if (bt) {
            workManager.enqueue(request)

            workManager.getWorkInfoByIdLiveData(request.id)
              .observe(this) {
                println("========== Work status: $it.status  \n")
                //  stats= "\n"+it.state.name+"\n"
              }
          }
          Column() {
            Button(onClick = {
              bt = !bt
              // notifexpl("Message received from xxxxx065","Good Morning!",applicationContext)
            }) {
              Text(text = "show notification!")
            }
            Text(text = stats)
          }
        }
      }
    }
  }
}

@Composable
fun Greeting10(name: String, modifier: Modifier = Modifier) {
  Text(
    text = "Hello $name!",
    modifier = modifier
  )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview10() {
  MyApplicationTheme {
    Greeting10("Android")
  }
}