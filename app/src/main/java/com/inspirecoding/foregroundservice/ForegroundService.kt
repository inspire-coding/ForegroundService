package com.inspirecoding.foregroundservice

import android.content.Intent
import android.os.IBinder
import androidx.core.app.NotificationCompat
import android.app.PendingIntent
import android.app.Service
import com.inspirecoding.foregroundservice.MainApplication.Companion.CHANNEL_ID

class ForegroundService: Service()
{
    override fun onCreate() {
        super.onCreate()
    }

    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
        val input = intent.getStringExtra("text")

        val notificationIntent = Intent(this, MainActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(
            this, 0, notificationIntent, 0 )

        val notification = NotificationCompat.Builder(this, CHANNEL_ID)
            .setContentTitle("ForegroundService Example")
            .setContentText(input)
            .setSmallIcon(R.drawable.ic_notifications)
            .setContentIntent(pendingIntent)
            .build()

        startForeground(1, notification)

        return START_NOT_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onBind(intent: Intent): IBinder? {
        return null
    }
}