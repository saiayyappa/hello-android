import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import com.example.myapplication.MainActivity

fun createNotification(title: String, description: String, applicationContext: Context): Boolean {

  var notificationManager =
    applicationContext.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

  if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
    val notificationChannel =
      NotificationChannel("101", "channel", NotificationManager.IMPORTANCE_DEFAULT)
    notificationManager.createNotificationChannel(notificationChannel)
  }

  var inte = Intent(applicationContext, MainActivity::class.java)

  var pendin = PendingIntent.getActivity(
    applicationContext, 0, inte, PendingIntent.FLAG_IMMUTABLE
  )
  val notificationBuilder =
    NotificationCompat.Builder(applicationContext, "101").setContentTitle(title)
      .setContentText(description).setContentIntent(pendin)
      .setSmallIcon(android.R.drawable.star_big_on)

  notificationManager.notify(1, notificationBuilder.build())

  return true
}