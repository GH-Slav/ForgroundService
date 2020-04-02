package by.tms.forgroundservice

import android.app.PendingIntent
import android.app.Service
import android.content.Intent
import android.os.IBinder
import androidx.core.app.NotificationCompat

class MyService : Service() {
    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val massage = intent?.getStringExtra("KEY")

        val intentBroadcast = Intent(this, PlayReceiver::class.java)
        val pendingIntent = PendingIntent.getBroadcast(
            this, 0, intentBroadcast, 0
        )

        val notification = NotificationCompat.Builder(this, CHANNEL_ID)
            .setContentTitle("My service")
            .setContentText(massage)
            .setSmallIcon(R.drawable.ic_wb_sunny_black_24dp)
            .addAction(R.drawable.ic_wb_sunny_black_24dp, "PLAY", pendingIntent)
            .build()

        startForeground(1, notification)

        return START_NOT_STICKY
    }
}