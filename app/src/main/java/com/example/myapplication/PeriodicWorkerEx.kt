package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.work.Constraints
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.NetworkType
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.PeriodicWorkRequest
import androidx.work.WorkManager
import androidx.work.WorkRequest
import com.example.myapplication.ui.theme.MyApplicationTheme
import java.util.concurrent.TimeUnit

class PeriodicWorkerEx : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      MyApplicationTheme {
        // A surface container using the 'background' color from the theme
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
          myWorkManager()
          simpleWork()
        }
      }
    }
  }

  private fun myWorkManager() {
    val constraints = Constraints.Builder()
      .setRequiresCharging(true)
      .setRequiredNetworkType(NetworkType.NOT_REQUIRED)
      .setRequiresCharging(true)
      .setRequiresBatteryNotLow(true)
      .build()

    val myRequest = PeriodicWorkRequest.Builder(
      MyWork::class.java, 15, TimeUnit.MINUTES
    ).setConstraints(constraints)
      .build()

    WorkManager.getInstance(this)
      .enqueueUniquePeriodicWork(
        "my_id",
        ExistingPeriodicWorkPolicy.KEEP,
        myRequest
      )
  }

  private fun simpleWork() {
    val mRequest: WorkRequest = OneTimeWorkRequestBuilder<MyWork>().build()
    WorkManager.getInstance(this).enqueue(mRequest)
  }
}

