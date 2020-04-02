package by.tms.forgroundservice

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build

const val CHANNEL_ID = "CHANNEL_ID"

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        createChannel()
    }

    private fun createChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                CHANNEL_ID,
                "ServiceChannel",
                NotificationManager.IMPORTANCE_DEFAULT
            )
            val notificationManager = getSystemService(NotificationManager::class.java)
            notificationManager?.createNotificationChannel(channel)
        }
    }
}